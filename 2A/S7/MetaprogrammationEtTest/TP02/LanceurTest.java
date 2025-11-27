/** LanceurTest permet de tester le Lanceur grâce aux classes de test déjà
 * écrites. */

public class LanceurTest {

    public void testMonnaieTest(){
        LanceurIndependant li = new LanceurIndependant("MonnaieTest");
        // Vérifier les résultats
        Assert.assertTrue(li.getNbTests() == 2);
        Assert.assertTrue(li.getNbErreurs() == 0);
        Assert.assertTrue(li.getNbEchecs() == 0);
    }

    public void testMonnaieTest2(){
        LanceurIndependant li = new LanceurIndependant("MonnaieTest2");
        // Vérifier les résultats
        Assert.assertTrue(li.getNbTests() == 3);
        Assert.assertTrue(li.getNbErreurs() == 0);
        Assert.assertTrue(li.getNbEchecs() == 0);
    }

    public void testCasLimitesTest(){
        LanceurIndependant li = new LanceurIndependant("CasLimitesTest");
        // Vérifier les résultats
        Assert.assertTrue(li.getNbTests() == 1);
        Assert.assertTrue(li.getNbErreurs() == 0);
        Assert.assertTrue(li.getNbEchecs() == 0);
    }

    public void testErreurTest(){
        LanceurIndependant li = new LanceurIndependant("ErreurTest");
        // Vérifier les résultats
        Assert.assertTrue(li.getNbTests() == 3);
        Assert.assertTrue(li.getNbErreurs() == 0);
        Assert.assertTrue(li.getNbEchecs() == 1);
    }
}