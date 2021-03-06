package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;

class ConcreteEnemy extends AbstractEnemy {

    ConcreteEnemy(String enemyName, Vector2 position) {
        if (enemyName.equals("EasyEnemy")) {
            enemiesList.add(new EasyEnemy(position));
        } else if (enemyName.equals("MediumEnemy")) {
            enemiesList.add(new MediumEnemy(position));
        } else if (enemyName.equals("DifficultEnemy")) {
            enemiesList.add(new DifficultEnemy(position));
        }

    }

    ConcreteEnemy() {
    }
}

final class EasyEnemy extends ConcreteEnemy {
    EasyEnemy(Vector2 position) {
        withoutThrust = new Sprite(new Texture("images/EasyEnemy.png"));
        withThrust = new Sprite(new Texture("images/EasyEnemyGreenThrust.png"));
        sprite = new Sprite(withoutThrust);
        velocity = new Vector2(0, 0);
        min_distance = 550;
        aggroDistance = 700;
        health = 100;
        MAX_HEALTH = 100;
        this.position = position;
        sprite.setPosition(position.x, position.y);
        ACCELERATION = 0.004f;
        DECELERATION = 0.997f;
        startTime = TimeUtils.millis();
    }
}

final class MediumEnemy extends ConcreteEnemy {
    MediumEnemy(Vector2 position) {
        withoutThrust = new Sprite(new Texture("images/MediumEnemy.png"));
        withThrust = new Sprite(new Texture("images/MediumEnemyWithGreenThrust.png"));
        sprite = new Sprite(withoutThrust);
        velocity = new Vector2(0, 0);
        min_distance = 550;
        aggroDistance = 700;
        health = 100;
        MAX_HEALTH = 100;
        this.position = position;
        sprite.setPosition(position.x, position.y);
        ACCELERATION = 0.004f;
        DECELERATION = 0.997f;
        startTime = TimeUtils.millis();
    }
}

final class DifficultEnemy extends ConcreteEnemy {
    DifficultEnemy(Vector2 position) {
        withoutThrust = new Sprite(new Texture("images/DifficultEnemy.png"));
        withThrust = new Sprite(new Texture("images/DifficultEnemyWithGreenThrust.png"));
        sprite = new Sprite(withoutThrust);
        velocity = new Vector2(0, 0);
        min_distance = 550;
        aggroDistance = 700;
        health = 100;
        MAX_HEALTH = 100;
        this.position = position;
        sprite.setPosition(position.x, position.y);
        ACCELERATION = 0.004f;
        DECELERATION = 0.997f;
        startTime = TimeUtils.millis();
    }
}