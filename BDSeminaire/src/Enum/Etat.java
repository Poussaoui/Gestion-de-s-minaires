package Enum;

public enum Etat {

    confirmé,
    annulé;

    public Etat getEtat(String s) {
        Etat e = null;
        if (!(s.equals("annulé") && s.equals("confirmé"))) {
            return null;
        } else {
            if (s.equals("annulé")) {
                e = annulé;
            } else if (s.equals("confirmé")) {
                e = confirmé;
            }
        }
        return e;
    }

    public boolean equals(Etat e) {
        if (e.equals("confirmé")) {
            e = confirmé;
        } else if (e.equals(this)) {
            return false;
        }
        return false;

    }
}
