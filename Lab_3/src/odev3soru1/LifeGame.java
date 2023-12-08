package odev3soru1;

import java.io.IOException;

public class LifeGame {
    final int habitatSatir = 19;
    final int habitatSutun = 19;
    int hucreHabitat[][];
    int hucreHabitatTmp[][];
    int[] pulsarSatir;
    int[] pSatir;
    int pulsarSutun[];

    public LifeGame() {
        pSatir = new int[]{3, 8, 10, 15};
        pulsarSatir = new int[]{0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0};
        pulsarSutun = new int[]{0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0};

        hucreHabitat = new int[habitatSatir][habitatSutun];
        hucreHabitatTmp = new int[habitatSatir][habitatSutun];

        for (int i = 0; i < habitatSatir; i++) {
            for (int y = 0; y < habitatSutun; y++) {
                hucreHabitatTmp[i][y] = 0;
                hucreHabitat[i][y] = 0;
            }
        }

        for (int satir = 0; satir < pSatir.length; satir++) {
            for (int sutun = 0; sutun < habitatSutun; sutun++) {
                hucreHabitat[pSatir[satir]][sutun] = pulsarSatir[sutun];
            }
        }

        for (int sutun = 0; sutun < pSatir.length; sutun++) {
            for (int satir = 0; satir < habitatSutun; satir++) {
                hucreHabitat[satir][pSatir[sutun]] = pulsarSatir[satir];
            }
        }
    }

    public void drawHabitat() {
        for (int i = 1; i < habitatSatir - 1; i++) {
            for (int y = 1; y < habitatSutun - 1; y++) {
                if (hucreHabitat[i][y] == 0) {
                    System.out.print("-");
                } else {
                    System.out.print("#");
                }
            }
            System.out.println();
        }
    }

    public int komsuCanliSayisi(int satir, int sutun) {
        int canliKomsuSayisi = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (!(i == 0 && j == 0) && hucreHabitat[satir + i][sutun + j] == 1) {
                    canliKomsuSayisi++;
                }
            }
        }
        return canliKomsuSayisi;
    }

    public void newHabitatRule() {
        int cks;

        for (int i = 1; i < habitatSatir - 1; i++) {
            for (int j = 1; j < habitatSutun - 1; j++) {
                cks = komsuCanliSayisi(i, j);

                if (hucreHabitat[i][j] == 1) {
                    if (cks < 2 || cks > 3) {
                        hucreHabitatTmp[i][j] = 0;
                    } else {
                        hucreHabitatTmp[i][j] = 1;
                    }
                } else {
                    if (cks == 3) {
                        hucreHabitatTmp[i][j] = 1;
                    } else {
                        hucreHabitatTmp[i][j] = 0;
                    }
                }
            }
        }

        copyHabitat();
    }

    public void copyHabitat() {
        for (int i = 0; i < habitatSatir; i++) {
            for (int j = 0; j < habitatSutun; j++) {
                hucreHabitat[i][j] = hucreHabitatTmp[i][j];
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        LifeGame lg = new LifeGame();
        for (int i = 0; i < 3; i++) {
            lg.drawHabitat();
            lg.newHabitatRule();
            System.out.println();
            Thread.sleep(1500);
        }
    }
}