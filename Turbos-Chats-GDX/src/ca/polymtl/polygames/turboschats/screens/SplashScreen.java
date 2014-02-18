package ca.polymtl.polygames.turboschats.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * <p>
 * Represents the splash screen that is shown at the start of the game.
 * It draws the PolyGames logo onto the screen.
 * <p>
 * @see Screen
 * @author Nicolas Richard */
public final class SplashScreen implements Screen {
	
	private SpriteBatch batch;
	private Sprite polyGamesLogo;	
	private OrthographicCamera camera;
	
	/** 
	 * Render the PolyGames logo onto the screen.
	 * It assumes that SpriteBatch.begin() as been called prior to it's call.
	 * @see Screen#render(float) */
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		batch.begin();
		polyGamesLogo.draw(batch);
		batch.end();
	}
	
	/** @see Screen#resize(int, int) */
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	/** @see Screen#show() */
	@Override
	public void show() {
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		camera = new OrthographicCamera(1, h/w);
		
		batch = new SpriteBatch();
		batch.setProjectionMatrix(camera.combined);
		Texture texture = new Texture(Gdx.files.internal("data/splashscreen/polygameslogo.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		polyGamesLogo = new Sprite(texture);
		polyGamesLogo.setSize(1, polyGamesLogo.getHeight()/polyGamesLogo.getWidth());
		polyGamesLogo.setOrigin(polyGamesLogo.getWidth()/2, polyGamesLogo.getHeight()/2);
		polyGamesLogo.setPosition(-polyGamesLogo.getWidth()/2, -polyGamesLogo.getHeight()/2);
	}

	/** @see Screen#hide() */
	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	/** @see Screen#pause() */
	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	/** @see Screen#resume() */
	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	/** @see Screen#dispose() */
	@Override
	public void dispose() {
		batch.dispose();
	}
}
