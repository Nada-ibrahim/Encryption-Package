/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SecurityMath;

/**
 *
 * @author Yassmin
 */

public class Add implements MathOp {
    @Override
    public int call(int a, int b, int mod) {
        return (a+b)%mod;
    }
}
