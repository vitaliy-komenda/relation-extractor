package gov.ornl.stucco.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents an entity in the knowledge graph.
 *
 */
public class Vertex {
	
	private static final String _type = "vertex";
			
	private String _id;
	private String vertexType;
	private Map<String, String> properties;
	
	public Vertex(String id, String type) {
		this._id = id;
		this.vertexType = type;
		this.properties = new HashMap<String, String>();
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getVertexType() {
		return vertexType;
	}

	public void setVertexType(String vertexType) {
		this.vertexType = vertexType;
	}

	public Map<String, String> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}

	public void addProperty(String propertyName, String propertyValue) {
		properties.put(propertyName, propertyValue);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_id == null) ? 0 : _id.hashCode());
		result = prime * result
				+ ((properties == null) ? 0 : properties.hashCode());
		result = prime * result
				+ ((vertexType == null) ? 0 : vertexType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (_id == null) {
			if (other._id != null)
				return false;
		} else if (!_id.equals(other._id))
			return false;
		if (vertexType == null) {
			if (other.vertexType != null)
				return false;
		} else if (!vertexType.equals(other.vertexType))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Vertex [_id=" + _id + ", vertexType=" + vertexType
				+ ", properties=" + properties + "]";
	}
	
	public String toGraphSON() {
		StringBuilder graph = new StringBuilder();
		
		graph.append("{");
		
		graph.append("\"_id\":\"");
		graph.append(_id);
		graph.append("\",");
		
		graph.append("\"_type\":\"");
		graph.append(_type);
		graph.append("\",");
		
		graph.append("\"vertexType\":\"");
		graph.append(vertexType);
		graph.append("\",");
		
		for(String prop : properties.keySet()) {
			graph.append("\"");
			graph.append(prop);
			graph.append("\":\"");
			graph.append(properties.get(prop));
			graph.append("\",");
		}
		graph.deleteCharAt(graph.length()-1);
		
		graph.append("}");
		
		return graph.toString();
	}
}
