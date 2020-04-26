package graphics;

import org.lwjgl.opengl.GL15;

public class VertexBuffer {
	
	private int id;
	VertexCollection vertices;
	
	public VertexBuffer(VertexCollection vertices) {
		super();
		
		id = GL15.glGenBuffers();
		this.vertices = vertices;
		bind();
		GL15.glBufferData(
				GL15.GL_ARRAY_BUFFER,
				vertices.getData(),
				GL15.GL_STATIC_DRAW);
		VertexBuffer.unbind();
		
	}
	
	public void bind() {
		//GL11.glEnableClientState(GL11.GL_VERTEX_ARRAY);
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, id);
		//GL11.glVertexPointer(3, GL11.GL_FLOAT, 0, vertices);
	}
	
	public static void unbind() {
		GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
	}

	public int getId() {
		return id;
	}
	
	public int getVertexCount() {
		return vertices.getVertexCount();
	}
	
	public int getVertexSize() {
		return vertices.getVertexSize();
	}
	
	public void close() {
		GL15.glDeleteBuffers(id);
	}
	
}
