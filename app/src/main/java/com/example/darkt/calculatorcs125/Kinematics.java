package com.example.darkt.calculatorcs125;

public class Kinematics {
    private double vi;
    private double vf;
    private double d;
    private double t;
    private double a;
    private String successful;

    public Kinematics() {
        vi = 0.0;
        vf = 0.0;
        d = 0.0;
        t = 0.0;
        a = 0.0;
    }
    public String getVi() {
        return "" + vi;
    }
    public String getVf() {
        return "" + vf;
    }
    public String getDisp() {
        return "" + d;
    }
    public String getTim() {
        return "" + t;
    }
    public String getAcc() {
        return "" + a;
    }
    public String getSuccessful() {
        return successful;
    }
    public String kinematics1(String vInit, String vFin, String disp, String time) {
        try {
            if (vFin.equals("")) {
                vi = Double.parseDouble(vInit);
                d = Double.parseDouble(disp);
                t = Double.parseDouble(time);
                vf = 2 * d / t - vi;
                a = (vf - vi) / t;
                successful = "successful";
                return String.format("%.3f", vf);
            } else if (vInit.equals("")) {
                vf = Double.parseDouble(vFin);
                d = Double.parseDouble(disp);
                t = Double.parseDouble(time);
                vi = 2 * d / t - vf;
                a = (vf - vi) / t;
                successful = "successful";
                return String.format("%.3f", vi);
            } else if (disp.equals("")) {
                vf = Double.parseDouble(vFin);
                vi = Double.parseDouble(vInit);
                t = Double.parseDouble(time);
                d = (vi + vf) / 2 * t;
                a = (vf - vi) / t;
                successful = "successful";
                return String.format("%.3f", d);
            } else if (time.equals("")) {
                vf = Double.parseDouble(vFin);
                vi = Double.parseDouble(vInit);
                d = Double.parseDouble(disp);
                t = 2 * d / (vi + vf);
                a = (vf - vi) / t;
                successful = "successful";
                return String.format("%.3f", t);
            }
            successful = "error";
            return "Only one of the variables must be empty";
        } catch (Exception e) {
            successful = "exception detected";
            return "Two or more variables can not be empty";
        }
    }
    public String kinematics2(String vInit, String vFin, String time, String acc) {
        try {
            if (vFin.equals("")) {
                vi = Double.parseDouble(vInit);
                a = Double.parseDouble(acc);
                t = Double.parseDouble(time);
                vf = vi + a * t;
                d = 0.5 * a * t * t + vi * t;
                successful = "successful";
                return String.format("%.3f", vf);
            } else if (vInit.equals("")) {
                vf = Double.parseDouble(vFin);
                a = Double.parseDouble(acc);
                t = Double.parseDouble(time);
                vi = vf - a * t;
                d = 0.5 * a * t * t + vi * t;
                successful = "successful";
                return String.format("%.3f", vi);
            } else if (acc.equals("")) {
                vf = Double.parseDouble(vFin);
                vi = Double.parseDouble(vInit);
                t = Double.parseDouble(time);
                a = (vf - vi) / t;
                d = 0.5 * a * t * t + vi * t;
                successful = "successful";
                return String.format("%.3f", a);
            } else if (time.equals("")) {
                vf = Double.parseDouble(vFin);
                vi = Double.parseDouble(vInit);
                a = Double.parseDouble(acc);
                t = (vf - vi) / a;
                d = 0.5 * a * t * t + vi * t;
                successful = "successful";
                return String.format("%.3f", t);
            }
            successful = "error";
            return "Only one of the variables must be empty";
        } catch (Exception e) {
            successful = "exception detected";
            return "Two or more variables can not be empty";
        }
    }
    public String kinematics3(String vInit, String disp, String time, String acc) {
        try {
            if (vInit.equals("")) {
                d = Double.parseDouble(disp);
                a = Double.parseDouble(acc);
                t = Double.parseDouble(time);
                vi = (d - 0.5 * a * Math.pow(t, 2)) / t;
                vf = vi + a * t;
                successful = "successful";
                return String.format("%.3f", vi);
            } else if (disp.equals("")) {
                vi = Double.parseDouble(vInit);
                a = Double.parseDouble(acc);
                t = Double.parseDouble(time);
                d = 0.5 * a * Math.pow(t, 2) + vi * t;
                vf = vi + a * t;
                successful = "successful";
                return String.format("%.3f", d);

            } else if (acc.equals("")) {
                d = Double.parseDouble(disp);
                vi = Double.parseDouble(vInit);
                t = Double.parseDouble(time);
                a = 2 * (d - vi * t) / Math.pow(t, 2);
                vf = vi + a * t;
                successful = "successful";
                return String.format("%.3f", a);
            } else if (time.equals("")) {
                d = Double.parseDouble(disp);
                vi = Double.parseDouble(vInit);
                a = Double.parseDouble(acc);
                if (a == 0) {
                    t = d / vi;
                }
                else {
                    if ((-1 * vi + Math.sqrt(vi * vi + 2 * a * d)) / a > 0) {
                        t = -1 * vi + Math.sqrt(vi * vi + 2 * a * d);
                    } else {
                        t = -1 * vi - Math.sqrt(vi * vi + 2 * a * d) / a;
                    }
                }
                vf = vi + a * t;
                successful = "successful";
                return String.format("%.3f", t);
            }
            successful = "Error";
            return "Only one of the variables must be empty";
        } catch (Exception e) {
            successful = "exception detected";
            return "Two or more variables can not be empty";
        }
    }
    public String kinematics4(String vInit, String vFin, String disp, String acc) {
        try {
            if (vFin.equals("")) {
                d = Double.parseDouble(disp);
                a = Double.parseDouble(acc);
                vi = Double.parseDouble(vInit);
                vf = Math.sqrt(vi * vi + 2 * a * d);
                t = (vf - vi) / a;
                successful = "successful";
                return String.format("%.3f", vf);
            } else if (vInit.equals("")) {
                vf = Double.parseDouble(vFin);
                a = Double.parseDouble(acc);
                d = Double.parseDouble(disp);
                vi = Math.sqrt(vf * vf - 2 * a * d);
                t = (vf - vi) / a;
                successful = "successful";
                return String.format("%.3f", vi);
            } else if (disp.equals("")) {
                vi = Double.parseDouble(vInit);
                vf = Double.parseDouble(vFin);
                a = Double.parseDouble(acc);
                d = Math.pow(vf, 2) - Math.pow(vi, 2) / (2 * a);
                t = (vf - vi) / a;
                successful = "successful";
                return String.format("%.3f", d);
            } else if (acc.equals("")) {
                d = Double.parseDouble(disp);
                vi = Double.parseDouble(vInit);
                vf = Double.parseDouble(vFin);
                a = (Math.pow(vf, 2) - Math.pow(vi, 2)) / (2 * d);
                t = (vf - vi) / a;
                successful = "successful";
                return String.format("%.3f", a);
            }
            successful = "error";
            return "Only one of the variables must be empty";
        } catch (Exception e) {
            successful = "exception detected";
            return "Two or more variables can not be empty";
        }
    }
}