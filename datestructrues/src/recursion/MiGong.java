package recursion;

/**
 * @author maverick
 * @create 2020-12-08 19:21
 */
public class MiGong {
    public static void main(String[] args) {

        int[][] map = new int[8][7];

        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
//        map[1][2] = 1;
//        map[2][2] = 1;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(" "+ map[i][j] );
            }
            System.out.println();
        }

        //以上是迷宫的地图

        System.out.println(setWay(map, 1, 1));

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(" "+ map[i][j] );
            }
            System.out.println();
        }

    }

    /**
     * 约定迷宫的规则，迷宫的四周外围墙和障碍物用1来模拟不可以走，迷宫中可以走的路标记为0，终点这里默认指定（6，5）为出口。模拟找路默认规则每次先下走（走的同时返回ture走不通时返回false）
     * 若走得通则进行下一步，若走不通再向左走同样走得通下一步，走不通则再向上走，同样走得通向左走，走得通则先一步走不通，证明时思路标记为3，如果返回true即走的通标记2
     *
     * 使用递归回溯的思想，模拟给定迷宫、给定起点、给定出口，走出迷宫的路线
     * @param map 给的迷宫地图
     * @param i i指定起点的迷宫中的横坐标
     * @param j i指定起点的迷宫中的横坐标
     * @return
     */
    public static boolean setWay(int[][] map,int i,int j){
        //第一步：进入迷宫（由于递归回溯的原因，可能时第一次执行也可能是第n次执行）故先判断是否是出口坐标，如果是则返回true，如果不是则执行找路逻辑
        if(map[6][2]  ==  2){
            return true;
        }else{
            //第二步：判断当前坐标是否为0，如果为0证明可以走
            if(map[i][j] == 0){
                //第三步，先将当前坐标标记为通路2.再进行下一步尝试，下一个可以是上下左右
                map[i][j] = 2;
                //下一步逻辑点
                //①先判断向下能否走通
                if(setWay(map,i + 1,j)){
                    return true;
                }
                //②次判断向又能否走通
                if(setWay(map,i,j + 1)){
                    return true;
                }
                //③再判断向左能否走通
                if(setWay(map,i - 1, j)){
                    return true;
                }
                //④最后判断向上能否走通
                if(setWay(map,i,j - 1)){
                    return true;
                }
                //⑤如果上下左右都为思路，则标记为思路3
                else{
                    map[i][j] = 3;
                    return false;
                }
            }else{//如果不为0可能为1、2、3，分表表示墙、走过的路、死路。直接返回false
                return false;
            }
        }
    }
}
