package kcsj.edu.common.pojo;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 自定义响应结构
 * @Description TODO
 * @ClassName HttpResult
 * @author Tao
 * @date 2018年1月14日
 */
public class HttpResult {
	
	private static final ObjectMapper MAPPER = new ObjectMapper();
	
	//响应业务状态
	private Integer status;
	//响应消息
	private String msg;
	//响应中的数据
	private Object data;
	
	public static HttpResult build(Integer status, String msg, Object data) {
		return new HttpResult(status, msg, data);
	}
	
	public static HttpResult build(Integer status, String msg) {
		return new HttpResult(status, msg, null);
	}
	
	public static HttpResult ok(Object data) {
		return new HttpResult(data);
	}
	
	public static HttpResult ok() {
		return new HttpResult(null);
	}
	
	public static HttpResult nofound() {
		return new HttpResult(404, "找不到指定资源", null);
	}
	
	public HttpResult() {}
	
	public HttpResult(Integer status, String msg, Object data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
	}
	
	public HttpResult(Object data) {
		this.status = 200;
		this.msg = "OK";
		this.data = data;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	/**
     * Object是POJO转化
     * 
     * @param jsonData json数据
     * @param clazz POJO中的类型
     * @return
     */
	public static HttpResult formatToPojo(String jsonData, Class<?> clazz) {
		try {
			if(clazz == null) {
				return MAPPER.readValue(jsonData, HttpResult.class);
			}
			JsonNode jsonNode = MAPPER.readTree(jsonData);
			JsonNode data = jsonNode.get("data");
			Object object = null;
			if(clazz != null) {
				if(data.isObject()) {
					object = MAPPER.readValue(data.traverse(), clazz);
				} else if (data.isTextual()) {
					object = MAPPER.readValue(data.asText(), clazz);
				}
			}
			return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), object);
		} catch (Exception e) {
			return null;
		}
		
	}
	
	 /**
     * 没有object对象的转化
     * 
     * @param json
     * @return
     */
    public static HttpResult format(String json) {
        try {
            return MAPPER.readValue(json, HttpResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

	
	/**
     * Object是集合转化
     * 
     * @param jsonData json数据
     * @param clazz 集合中的类型
     * @return
     */
    public static HttpResult formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("status").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }
}
