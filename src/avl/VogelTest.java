package avl;

interface Vogel {
    String machLaut();
}

class Rabe implements Vogel {
    @Override
    public String machLaut() {
        return "AARGH AAARGH";
    }
}

class Amsel implements Vogel {
    @Override
    public String machLaut() {
        return "Vodka Bull?!?";
    }
}

public class VogelTest {
    public static void main(String... args) {
        Rabe rabe = new Rabe();
        Amsel amsel = new Amsel();
        System.out.println(rabe.machLaut());
        System.out.println(amsel.machLaut());

        Vogel vieleVögel[] = new Vogel[2];
        vieleVögel[0] = rabe;
        vieleVögel[1] = amsel;

        for (Vogel vogel : vieleVögel) {
            System.out.println(vogel.machLaut());
        }
    }
}