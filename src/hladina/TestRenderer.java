package hladina;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;


import hladina.hladiny.PohybHladiny;
import transforms.Point2D;
import utils.OglUtils;

/**
 * trida pro zobrazeni sceny v OpenGL:
 * transformace v prostoru, FPS, perspektiva, viditelnost, pohled
 * @author PGRF FIM UHK
 * @version 2015
 */
public class TestRenderer implements GLEventListener, MouseListener,
		MouseMotionListener, KeyListener {

	GLUT glut;
	GLU glu;
	PohybHladiny pohybHladiny = new PohybHladiny(50,50,4);
	int width, height, dx, dy;
	int ox, oy;
	long oldmils;
	long oldFPSmils;
	double	fps;

	boolean light = false;
	float uhel = 0, uhelX, uhelY;
	int mode = 0;
	float m[] = new float[16];

	boolean per = true, depth = false;

	@Override
	public void init(GLAutoDrawable glDrawable) {
		GL2 gl = glDrawable.getGL().getGL2();
		glut = new GLUT();
		glu = new GLU();

		OglUtils.printOGLparameters(gl);


		gl.glEnable(GL2.GL_DEPTH_TEST);


		// nastaveni materialu - difusni slozka
		float[] mat_dif = new float[] { 0, 0, 1, 1 };
		// nastaveni materialu - zrcadlova slozka
		float[] mat_spec = new float[] { 0.0f, 0.0f, 1.0f, 1 };
		// nastaveni materialu - ambientni slozka
		float[] mat_amb = new float[] { 0.0f, 0.0f, 0.1f, 1 };

		gl.glMaterialfv(GL2.GL_FRONT, GL2.GL_AMBIENT, mat_amb, 0);
		gl.glMaterialfv(GL2.GL_FRONT, GL2.GL_DIFFUSE, mat_dif, 0);
		gl.glMaterialfv(GL2.GL_FRONT, GL2.GL_SPECULAR, mat_spec, 0);
		// gl.glMaterialfv(GL2.GL_FRONT, GL2.GL_EMISSION, mat, 0);

		// nastaveni zdroje svetla - ambientni slozka
		float[] light_amb = new float[] { 1, 1, 1, 1 };
		// nastaveni zdroje svetla - difusni slozka
		float[] light_dif = new float[] { 1, 1, 1, 1 };
		// nastaveni zdroje svetla - zrcadlova slozka
		float[] light_spec = new float[] { 0.0f, 0, 0.3f, 1 };

		gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_AMBIENT, light_amb, 0);
		gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_DIFFUSE, light_dif, 0);
		gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_SPECULAR, light_spec, 0);


		gl.glFrontFace(GL2.GL_CCW);

		gl.glPolygonMode(GL2.GL_FRONT, GL2.GL_FILL);
		gl.glPolygonMode(GL2.GL_BACK, GL2.GL_LINE);
		gl.glDisable(GL2.GL_CULL_FACE);
		gl.glDisable(GL2.GL_TEXTURE_2D);
		gl.glDisable(GL2.GL_LIGHTING);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();

		gl.glLoadIdentity();
		gl.glGetFloatv(GL2.GL_MODELVIEW_MATRIX, m, 0);

	}

	@Override
	public void display(GLAutoDrawable glDrawable) {
		GL2 gl = glDrawable.getGL().getGL2();


		// zapnuti nebo vypnuti viditelnosti
		if (depth)
			gl.glEnable(GL2.GL_DEPTH_TEST);
		else
			gl.glDisable(GL2.GL_DEPTH_TEST);

		// mazeme image buffer i z-buffer
		gl.glClearColor(0f, 0f, 0f, 1f);
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
		//gl.glEnable(GL2.GL_DEPTH_TEST);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();


		gl.glPushMatrix();
		gl.glLoadIdentity();
		if (pohybHladiny.getModyZobrazeni()==3) {

			// zapnuti svetla
			float[] light_position;
			light_position = new float[] { -50, 0, 20, 0.0f };// bod v prostoru
			gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_POSITION, light_position, 0);
			gl.glEnable(GL2.GL_LIGHTING);
			gl.glEnable(GL2.GL_LIGHT0);
			gl.glEnable(GL2.GL_CULL_FACE);
			gl.glCullFace(GL2.GL_BACK);
			gl.glShadeModel(GL2.GL_SMOOTH);

			gl.glFrontFace(GL2.GL_CCW);


		}else  {
			// vypnuti svetla
			gl.glDisable(GL2.GL_LIGHTING);
			gl.glDisable(GL2.GL_LIGHT0);
			gl.glDisable(GL2.GL_CULL_FACE);
			gl.glShadeModel(GL2.GL_LINES);
			gl.glFrontFace(GL2.GL_CCW);
		}







		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();

		// nastaveni transformace zobrazovaciho objemu

		if (per)
			glu.gluPerspective(45, width / (float) height, 0.1f, 100.0f);
		else
			gl.glOrtho(-20 * width / (float) height, 20 * width
					/ (float) height, -20, 20, 0.1f, 100.0f);


		// pohledova transformace
		// divame se do sceny z kladne osy x, osa z je svisla
		glu.gluLookAt(50, 0, 20, 0, 0, 0, 0, 0, 1);





		gl.glBegin(GL2.GL_TRIANGLES);
		gl.glColor3d(0, 0, 255);


		pohybHladiny.trouhelnik(glDrawable);
		gl.glEnd();

		String text = new String("[lmb] trigger hladiny, ");

		if (per)
			text = new String(text + "[P]ersp, ");
		else
			text = new String(text + "[p]ersp, ");


		text = new String(text + "View [M]ode: " + pohybHladiny.getModyZobrazeni() + ", " );
		text = new String(text + "Pohyb hran [NUM] klavesy, " );
		text = new String(text + "[S]in /[C]os pohyb v pocatku" );

		OglUtils.drawStr2D(glDrawable, 3, height-20, text);
		text = new String("SPACE reset");
		OglUtils.drawStr2D(glDrawable, 3, height-35, text);

		OglUtils.drawStr2D(glDrawable, width-20, height-40, pohybHladiny.getModyTFS(2));
		OglUtils.drawStr2D(glDrawable, width-30, height-40, pohybHladiny.getModyTFS(1));
		OglUtils.drawStr2D(glDrawable, width-40, height-40, pohybHladiny.getModyTFS(0));

		OglUtils.drawStr2D(glDrawable, width-20, height-55, pohybHladiny.getModyTFS(3));
		OglUtils.drawStr2D(glDrawable, width-40, height-55, pohybHladiny.getModyTFS(7));

		OglUtils.drawStr2D(glDrawable, width-20, height-70, pohybHladiny.getModyTFS(4));
		OglUtils.drawStr2D(glDrawable, width-30, height-70, pohybHladiny.getModyTFS(5));
		OglUtils.drawStr2D(glDrawable, width-40, height-70, pohybHladiny.getModyTFS(6));
/*
		double color[] = { 1.0, 1.0, 1.0 };
		gl.glColor3dv(color, 0);
*/







	}

	@Override
	public void reshape(GLAutoDrawable glDrawable, int x, int y, int width,
						int height) {
		this.width = width;
		this.height = height;
		glDrawable.getGL().getGL2().glViewport(0, 0, width , height);
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		dx = e.getX();
		dy = e.getY();



		//System.out.println("dx=" +dx + " dy= " + dy);
		//pohybHladiny.pohybMysi(dx,dy,2.0);

	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		ox = e.getX();
		oy = e.getY();
		//System.out.println("old: " + ox + " "+oy);
		//System.out.println("new: " + prepocetXY(ox,oy));
		//pohybHladiny.pohybMysi(prepocetXY(ox,oy),-2,2);

		if (e.getButton() == MouseEvent.BUTTON1) {

		}


	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		dx = e.getX() - ox;
		dy = e.getY() - oy;
		ox = e.getX();
		oy = e.getY();
		pohybHladiny.pohybMysi(prepocetXY(ox,oy),-2.0,2);

	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// switch (e.getKeyCode()) {
		// }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_P:
				per = !per;
				break;
			case KeyEvent.VK_D:
				depth = !depth;
				break;
			case KeyEvent.VK_M:
				pohybHladiny.modyZobrazeni();
				break;
			case KeyEvent.VK_S:
				pohybHladiny.pohybMysiSin(0,0,-5,5);
				break;
			case KeyEvent.VK_C:
				pohybHladiny.pohybMysi(0,0,-5,5);
				break;
			case KeyEvent.VK_SPACE:
				pohybHladiny.reset();
				break;
			case KeyEvent.VK_NUMPAD0:
				pohybHladiny.falseSeznam();
				break;
			case KeyEvent.VK_NUMPAD1:
				pohybHladiny.tfSeznam(6);
				break;
			case KeyEvent.VK_NUMPAD2:
				pohybHladiny.tfSeznam(5);
				break;
			case KeyEvent.VK_NUMPAD3:
				pohybHladiny.tfSeznam(4);
				break;
			case KeyEvent.VK_NUMPAD4:
				pohybHladiny.tfSeznam(7);
				break;
			case KeyEvent.VK_NUMPAD6:
				pohybHladiny.tfSeznam(3);
				break;
			case KeyEvent.VK_NUMPAD7:
				pohybHladiny.tfSeznam(0);
				break;
			case KeyEvent.VK_NUMPAD8:
				pohybHladiny.tfSeznam(1);
				break;
			case KeyEvent.VK_NUMPAD9:
				pohybHladiny.tfSeznam(2);
				break;
			case KeyEvent.VK_NUMPAD5:
				pohybHladiny.trueSeznam();
				break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void dispose(GLAutoDrawable glDrawable) {
	}

	private Point2D prepocetXY(double x, double y){

		final double  ry1= ((2*x)/(width-1)-1)*((pohybHladiny.getVodniHladina().getxMatice()-1)/pohybHladiny.getVodniHladina().getPointPerPoint() );
		final double  rx1= ((2*y)/(height-1)-1)*((pohybHladiny.getVodniHladina().getyMatice()-1)/pohybHladiny.getVodniHladina().getPointPerPoint() );



		return new Point2D(rx1,ry1);
	}



}