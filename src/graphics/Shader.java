package graphics;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.lwjgl.opengl.GL20;

public class Shader {
	
	private int id;
	private int type;
	
	public Shader(int type, String filename) throws IOException {
		super();
		
		this.type = type;
		
		byte[] encoded = Files.readAllBytes(Paths.get(filename));
		String source = new String(encoded, Charset.defaultCharset());
		
		id = GL20.glCreateShader(this.type);
		GL20.glShaderSource(id, source);
		GL20.glCompileShader(id);
		
	}
	
	public int getId() {
		return id;
	}

	public void close() {
		GL20.glDeleteShader(id);
	}
	
}
