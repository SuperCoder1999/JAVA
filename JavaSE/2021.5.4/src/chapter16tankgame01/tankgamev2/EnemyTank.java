package chapter16tankgame01.tankgamev2;

/*
    1. 因为敌人的坦克，以后有自己特殊的属性和方法，所以单开一个EnemyTank类。
    2. 敌人坦克数量多，可以考虑放入集合Vector中(Vector是线程安全的)
 */

public class EnemyTank extends FatherTank {
    public EnemyTank(int x, int y, int direct, int speed, int type) {
        super(x, y, direct, speed, type);
    }
}
