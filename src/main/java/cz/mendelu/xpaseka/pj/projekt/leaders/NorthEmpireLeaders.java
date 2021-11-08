package cz.mendelu.xpaseka.pj.projekt.leaders;

public abstract class NorthEmpireLeaders {
    private final String name;

    private NorthEmpireLeaders(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void applyAbility();

    public static final NorthEmpireLeaders THE_STEEL_FORGED = new NorthEmpireLeaders("The Steel-Forged") {
        @Override
        public void applyAbility() {
            // TODO
        }
    };

    public static final NorthEmpireLeaders THE_SIEGEMASTER = new NorthEmpireLeaders("The Siegemaster") {
        @Override
        public void applyAbility() {
            // TODO
        }
    };

    public static final NorthEmpireLeaders LORD_COMMANDER_OF_THE_NORTH = new NorthEmpireLeaders("Lord Commander of the North") {
        @Override
        public void applyAbility() {
            // TODO
        }
    };

    public static final NorthEmpireLeaders KING_OF_TEMERIA = new NorthEmpireLeaders("King of Temeria") {
        @Override
        public void applyAbility() {
            // TODO
        }
    };
}
