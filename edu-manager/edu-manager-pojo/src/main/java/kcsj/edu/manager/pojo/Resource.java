package kcsj.edu.manager.pojo;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 资源类(文章,下载资料)
 * 
 * @Description TODO
 * @ClassName Resource
 * @author Tao
 * @date 2018年3月10日
 */
@TableName("resource")
public class Resource {
	@TableId
	private int id;
	private String title;

	private String desc;

	private String download;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDownload() {
		return download;
	}

	public void setDownload(String download) {
		this.download = download;
	}

}
