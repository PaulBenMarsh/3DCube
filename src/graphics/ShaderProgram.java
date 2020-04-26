package graphics;

import java.util.ArrayList;

import org.lwjgl.opengl.GL20;

public class ShaderProgram {
	
	private int id;
	private ArrayList<Shader> shaders;
	
	public ShaderProgram() {
		super();
		
		id = GL20.glCreateProgram();
		shaders = new ArrayList<Shader>();
		
	}
	
	public void attach(Shader shader) {
		GL20.glAttachShader(id, shader.getId());
		shaders.add(shader);
	}
	
	public void link() {
		GL20.glLinkProgram(id);
		for (Shader shader : shaders) {
			shader.close();
		}
		shaders = new ArrayList<Shader>();
	}
	
	public void use() {
		GL20.glUseProgram(id);
	}
	
	

}
