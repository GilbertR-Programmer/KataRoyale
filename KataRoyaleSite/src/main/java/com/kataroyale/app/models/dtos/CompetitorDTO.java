package com.kataroyale.app.models.dtos;

import java.util.List;
import java.util.Map;

public class CompetitorDTO {
    private String username;
    private String name;
    private int honor;
    private String clan;
    private int leaderboardPosition;
    private List<String> skills;
    private Ranks ranks;
    private CodeChallenges codeChallenges;

    // Getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHonor() {
        return honor;
    }

    public void setHonor(int honor) {
        this.honor = honor;
    }

    public String getClan() {
        return clan;
    }

    public void setClan(String clan) {
        this.clan = clan;
    }

    public int getLeaderboardPosition() {
        return leaderboardPosition;
    }

    public void setLeaderboardPosition(int leaderboardPosition) {
        this.leaderboardPosition = leaderboardPosition;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public Ranks getRanks() {
        return ranks;
    }

    public void setRanks(Ranks ranks) {
        this.ranks = ranks;
    }

    public CodeChallenges getCodeChallenges() {
        return codeChallenges;
    }

    public void setCodeChallenges(CodeChallenges codeChallenges) {
        this.codeChallenges = codeChallenges;
    }

    public static class Ranks {
        private RankDetail overall;
        private Map<String, RankDetail> languages;

        // Getters and setters
        public RankDetail getOverall() {
            return overall;
        }

        public void setOverall(RankDetail overall) {
            this.overall = overall;
        }

        public Map<String, RankDetail> getLanguages() {
            return languages;
        }

        public void setLanguages(Map<String, RankDetail> languages) {
            this.languages = languages;
        }
    }

    public static class RankDetail {
        private int rank;
        private String name;
        private String color;
        private int score;

        // Getters and setters
        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }
    }

    public static class CodeChallenges {
        private int totalAuthored;
        private int totalCompleted;

        // Getters and setters
        public int getTotalAuthored() {
            return totalAuthored;
        }

        public void setTotalAuthored(int totalAuthored) {
            this.totalAuthored = totalAuthored;
        }

        public int getTotalCompleted() {
            return totalCompleted;
        }

        public void setTotalCompleted(int totalCompleted) {
            this.totalCompleted = totalCompleted;
        }
    }
}
