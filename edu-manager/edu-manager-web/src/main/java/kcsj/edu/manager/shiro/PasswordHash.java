package kcsj.edu.manager.shiro;

import org.apache.shiro.crypto.hash.SimpleHash;

public class PasswordHash{
	//算法名 md5 sha-256 ...
	private String algorithmName;
	//hash次数
	private int hashIterations;

	public String getAlgorithmName() {
		return algorithmName;
	}
	public void setAlgorithmName(String algorithmName) {
		this.algorithmName = algorithmName;
	}
	public int getHashIterations() {
		return hashIterations;
	}
	public void setHashIterations(int hashIterations) {
		this.hashIterations = hashIterations;
	}
	
	/**
	 * 加密函数 
	 * @param source 原密码
	 * @param salt 佐料,用于混淆密码破译者
	 * @return
	 */
	public String toHex(Object source, Object salt) {
		return new SimpleHash(algorithmName, source, salt, hashIterations).toHex();
	}
	
	/**
	 * 加密函数
	 * @param source 原密码
	 * @return
	 */
	public String toHex(Object source) {
		return new SimpleHash(algorithmName, source, hashIterations).toHex();
	}
}
