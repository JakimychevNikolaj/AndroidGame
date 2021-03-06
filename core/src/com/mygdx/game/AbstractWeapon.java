package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Button;

import java.util.ArrayList;

import static com.mygdx.game.MyGdxGame.batch;

public abstract class AbstractWeapon extends Entity {
    float speed;
    float cooldown;
    int distance;
    int damage;
    Vector2 playerPos;
    //    AbstractWeapon weapon;
    public static ArrayList<AbstractWeapon> listOfBullets = new ArrayList<AbstractWeapon>();

    public float getCooldown() {
        return cooldown;
    }

    boolean IsOutsideOfDistance() {
        return (position.x > playerPos.x + distance || position.x < playerPos.x - distance) ||
                (position.y > playerPos.y + distance || position.y < playerPos.y - distance);
    }

    public int getDamage() {
        return damage;
    }

    public void SmartMissileUpdate(Vector2 currentPlayerPosition) {
        angle = (float)
                ((Math.atan2(currentPlayerPosition.y - position.y, currentPlayerPosition.x - position.x)) *
                        180 / Math.PI);
        if (!IsOutsideOfDistance() && animation == null) {
            velocity.x = (float) Math.cos(angle * 0.017453f) * speed;
            velocity.y = (float) Math.sin(angle * 0.017453f) * speed;
            position.x += velocity.x;
            position.y += velocity.y;
            sprite.setRotation(angle);
            sprite.setX(position.x);
            sprite.setY(position.y);
        } else {
            CreateExplosion();
        }
    }

    public void Update(Vector2 currentPlayerPosition) {
        if (!IsOutsideOfDistance() && animation == null) {
            velocity.x = (float) Math.cos(angle * 0.017453f) * speed;
            velocity.y = (float) Math.sin(angle * 0.017453f) * speed;
            position.x += velocity.x;
            position.y += velocity.y;
            sprite.setX(position.x);
            sprite.setY(position.y);
        } else {
            if (this.getClass().getSimpleName().equals("Missile") ||
                    this.getClass().getSimpleName().equals("SmartMissile")) {
                CreateExplosion();
            } else {
                SetDead();
            }
        }
    }

    public void Draw() {
        this.GetSprite().draw(batch);
    }

    public void Update(TouchPad touchPad, Vector2 vector2) {
        Update(vector2);
        Draw();
    }
}
