/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WakeUp;

/**
 *
 * @author robin
 */
public class Member {

    private String persnr;
    private String namn;

    public Member(String persnr, String namn) {
        this.persnr = persnr;
        this.namn = namn;
    }

    public void setPersnr(String persnr) {
        this.persnr = persnr;
    }

    public String getPersnr() {
        return persnr;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public String getNamn() {
        return namn;
    }
}
