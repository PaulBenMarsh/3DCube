package graphics;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;

public class VertexCollection {
	
	private FloatBuffer vertices;
	private int vertexCount = 24;
	private int vertexSize = 3;
	
	public VertexCollection() {
		super();
		
		int capacity = vertexCount * vertexSize;
		vertices = BufferUtils.createFloatBuffer(capacity);
		vertices.put(new float[] {0.0f, 0.0f, 0.0f});
		vertices.put(new float[] {0.0f, 1.0f, 0.0f});
		
		vertices.put(new float[] {0.0f, 1.0f, 0.0f});
		vertices.put(new float[] {1.0f, 1.0f, 0.0f});
		
		vertices.put(new float[] {1.0f, 1.0f, 0.0f});
		vertices.put(new float[] {0.0f, 1.0f, 0.0f});
		
		vertices.put(new float[] {0.0f, 1.0f, 0.0f});
		vertices.put(new float[] {0.0f, 0.0f, 0.0f});
		
		vertices.put(new float[] {0.0f, 0.0f, 1.0f});
		vertices.put(new float[] {0.0f, 1.0f, 1.0f});
		
		vertices.put(new float[] {0.0f, 1.0f, 1.0f});
		vertices.put(new float[] {1.0f, 1.0f, 1.0f});
		
		vertices.put(new float[] {1.0f, 1.0f, 1.0f});
		vertices.put(new float[] {0.0f, 1.0f, 1.0f});
		
		vertices.put(new float[] {0.0f, 1.0f, 1.0f});
		vertices.put(new float[] {0.0f, 0.0f, 1.0f});
		
		vertices.put(new float[] {0.0f, 0.0f, 0.0f});
		vertices.put(new float[] {0.0f, 0.0f, 1.0f});
		
		vertices.put(new float[] {1.0f, 0.0f, 0.0f});
		vertices.put(new float[] {1.0f, 0.0f, 1.0f});
		
		vertices.put(new float[] {1.0f, 1.0f, 0.0f});
		vertices.put(new float[] {1.0f, 1.0f, 1.0f});
		
		vertices.put(new float[] {0.0f, 1.0f, 0.0f});
		vertices.put(new float[] {0.0f, 1.0f, 1.0f});
		
		vertices.flip();
		
	}

	public FloatBuffer getData() {
		return vertices;
	}
	
	public int getVertexCount() {
		return vertexCount;
	}
	
	public int getVertexSize() { 
		return vertexSize;
	}
	
}
