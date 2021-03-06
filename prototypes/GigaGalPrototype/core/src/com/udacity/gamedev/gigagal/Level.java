package com.udacity.gamedev.gigagal;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.udacity.gamedev.gigagal.entities.Enemy;
import com.udacity.gamedev.gigagal.entities.GigaGal;
import com.udacity.gamedev.gigagal.entities.Platform;

public class Level {

    GigaGal gigaGal;
    Array<Platform> platforms;
    Array<Enemy> enemies;

    public Level() {
        gigaGal = new GigaGal();
        platforms = new Array<Platform>();
        enemies = new Array<Enemy>();
        initDebugLevel();
    }

    public void update(float delta) {
        gigaGal.update(delta, platforms);
    }

    public void render(SpriteBatch batch) {
        batch.begin();
        for (Platform platform : platforms) {
            platform.render(batch);
        }

        for (Enemy enemy : enemies) {
            enemy.render(batch);
        }


        gigaGal.render(batch);
        batch.end();
    }

    private void initDebugLevel() {
        platforms.add(new Platform(15, 100, 30, 20));
        platforms.add(new Platform(75, 90, 100, 65));

        platforms.add(new Platform(10, 20, 20, 9));

        Platform enemyPlatform = new Platform(35, 55, 50, 20);
        platforms.add(enemyPlatform);
        enemies.add(new Enemy(enemyPlatform));


    }
}
