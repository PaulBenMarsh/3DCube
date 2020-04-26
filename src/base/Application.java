package base;

import graphics.OpenGLWindow;

public class Application {
	
	private OpenGLWindow window;
	
	public Application() throws Exception {
		super();
		
		window = new OpenGLWindow();
		
	}
	
	public void execute() {
		
		while(window.shouldKeepGoing()) {
			window.render();
			window.poll();
		}
		
		close();
		
	}
	
	public void close() {
		window.close();
	}

}
