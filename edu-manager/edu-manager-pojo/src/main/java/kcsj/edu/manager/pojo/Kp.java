package kcsj.edu.manager.pojo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 知识点
 * 
 * @Description TODO
 * @ClassName Kp
 * @author Tao
 * @date 2018年3月10日
 */
@TableName("kps")
public class Kp {
	@TableId
	private int id;

	private String name;

	@TableField("chapter_id")
	private int chapterId;
	@TableField("video_src")
	private String videoSrc;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getChapterId() {
		return chapterId;
	}

	public void setChapterId(int chapterId) {
		this.chapterId = chapterId;
	}

	public String getVideoSrc() {
		return videoSrc;
	}

	public void setVideoSrc(String videoSrc) {
		this.videoSrc = videoSrc;
	}

}
