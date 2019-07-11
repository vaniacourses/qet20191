package br.uff.qet.cardgame;

public class Score {
    private int score;
    
    public Score(){
        this.score = 0;
    }
    
    public int increaseByLevel(Level level){
        this.score += (level.ordinal()+1)*100;
        return score;
    }
    
    public int increaseByCard(Level level){
        this.score += (level.ordinal()+1)*10;
        return score;
    }

    public Object increaseByArtifact(Level level) {
        this.score += (level.ordinal()+1)*25;
        return score;
    }

    public Object increaseByRounds(Game game) {
        this.score += (game.getFinalRound() - game.getRound())*50;
        return score;
    }

    public Object increaseByResource(Player player) {
        this.score += (player.getResource()/10) * player.getCurrentMaturityLevel().getLevel().ordinal();
        return score;
    }
        
}