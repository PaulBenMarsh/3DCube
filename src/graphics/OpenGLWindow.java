package graphics;

import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import java.io.IOException;
import java.nio.*;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

public class OpenGLWindow {
	
	private long handle;
	
	private VertexBuffer buffer;
	
	private ShaderProgram shaderProgram;
	
	public OpenGLWindow() throws Exception {
		super();
		
		if (!glfwInit()) {
			throw new IllegalStateException("Could not initialize GLFW");			
		}
		
		glfwDefaultWindowHints();
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
		glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);
		
		int width = 300;
		int height = 300;
		String title = "3D";
		
		handle = glfwCreateWindow(width, height, title, NULL, NULL);
		if (handle == NULL) {
			throw new RuntimeException("Failed to create window");
		}
		
		glfwSetKeyCallback(handle, (window, key, scancode, action, mods) -> {
			if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )
				glfwSetWindowShouldClose(window, true);
		});

		try ( MemoryStack stack = stackPush() ) {
			IntBuffer pWidth = stack.mallocInt(1);
			IntBuffer pHeight = stack.mallocInt(1);

			glfwGetWindowSize(handle, pWidth, pHeight);

			GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

			glfwSetWindowPos(
					handle,
					(vidmode.width() - pWidth.get(0)) / 2,
					(vidmode.height() - pHeight.get(0)) / 2
					);
		}

		glfwMakeContextCurrent(handle);
		glfwSwapInterval(1);
		glfwShowWindow(handle);
		
		GL.createCapabilities();
		glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		GL20.glEnable(GL_DEPTH_TEST);
		
		buffer = new VertexBuffer(new VertexCollection());
		
//		shaderProgram = new ShaderProgram();
//		shaderProgram.attach(new Shader(GL20.GL_VERTEX_SHADER, "vshader.vert"));
//		shaderProgram.attach(new Shader(GL20.GL_FRAGMENT_SHADER, "fshader.frag"));
//		shaderProgram.link();
//		shaderProgram.use();
		
	}

	public void render() {
		
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glLoadIdentity();
		glColor3f(1.0f, 1.0f, 1.0f);
		
		buffer.bind();
		GL15.glVertexPointer(buffer.getVertexSize(), GL_FLOAT, 0, buffer.getId());
		
		GL15.glEnableClientState(GL_VERTEX_ARRAY);
		
		GL15.glDrawArrays(GL_LINES, 0, buffer.getVertexCount());
		
		GL15.glDisableClientState(GL_VERTEX_ARRAY);
		
//		glColor3f(1.0f, 1.0f, 1.0f);
//		glBegin(GL_QUADS);
//		glVertex3f(0.0f, 0.0f, 0.0f);
//		glVertex3f(1.0f, 0.0f, 0.0f);
//		glVertex3f(1.0f, 1.0f, 0.0f);
//		glVertex3f(0.0f, 1.0f, 0.0f);
//		glEnd();
		
		glfwSwapBuffers(handle);
	}
	
	public void poll() {
		glfwPollEvents();
	}
	
	public boolean shouldKeepGoing() {
		return !glfwWindowShouldClose(handle);
	}
	
	public void close() {
		buffer.close();
	}
	
}
