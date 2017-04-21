package org.tvrenamer.model;

import java.util.logging.Logger;

public class EpisodeTestData {
    private static Logger logger = Logger.getLogger(EpisodeTestData.class.getName());

    private static Integer fakeEpisodeIdCounter = 101;

    public final String filenameShow;
    public final String properShowName;
    public final String showId;
    public final String seasonNumString;
    public final String episodeNumString;
    public final String episodeResolution;
    public final String episodeTitle;
    public final String episodeId;
    public final String separator;
    public final String filenameSuffix;
    public final String replacementMask;
    public final String documentation;
    public final String expectedReplacement;
    public final String inputFilename;

    public static class Builder {
        private String filenameShow;
        private String properShowName;
        private String showId = "1";
        private String seasonNumString;
        private String episodeNumString;
        private String episodeResolution = "";
        private String episodeTitle;
        private String episodeId = null;
        private String separator = ".";
        private String filenameSuffix = ".avi";
        private String replacementMask = "%S [%sx%e] %t";
        private String documentation = null;
        private String expectedReplacement;

        public Builder() {
        }

        public Builder filenameShow(String val) {
            filenameShow = val;
            return this;
        }

        public Builder properShowName(String val) {
            properShowName = val;
            return this;
        }

        public Builder showId(String val) {
            showId = val;
            return this;
        }

        public Builder seasonNumString(String val) {
            seasonNumString = val;
            return this;
        }

        public Builder episodeNumString(String val) {
            episodeNumString = val;
            return this;
        }

        public Builder episodeResolution(String val) {
            episodeResolution = val;
            return this;
        }

        public Builder episodeTitle(String val) {
            episodeTitle = val;
            return this;
        }

        public Builder episodeId(String val) {
            episodeId = val;
            return this;
        }

        public Builder filenameSuffix(String val) {
            filenameSuffix = val;
            return this;
        }

        public Builder separator(String val) {
            separator = val;
            return this;
        }

        public Builder replacementMask(String val) {
            replacementMask = val;
            return this;
        }

        public Builder documentation(String val) {
            documentation = val;
            return this;
        }

        public Builder expectedReplacement(String val) {
            expectedReplacement = val;
            return this;
        }

        public EpisodeTestData build() {
            return new EpisodeTestData(this);
        }
    }

    public EpisodeTestData(Builder builder) {
        filenameShow = builder.filenameShow;
        properShowName = builder.properShowName;
        showId = builder.showId;
        seasonNumString = builder.seasonNumString;
        episodeNumString = builder.episodeNumString;
        episodeResolution = builder.episodeResolution;
        episodeTitle = builder.episodeTitle;
        if (builder.episodeId == null) {
            synchronized (fakeEpisodeIdCounter) {
                fakeEpisodeIdCounter++;
                episodeId = String.valueOf(fakeEpisodeIdCounter);
            }
        } else {
            episodeId = builder.episodeId;
        }
        separator = builder.separator;
        filenameSuffix = builder.filenameSuffix;
        replacementMask = builder.replacementMask;
        documentation = builder.documentation;
        expectedReplacement = builder.expectedReplacement;
        String resolutionString = "";
        if ((episodeResolution != null) && (episodeResolution.length() > 0)) {
            resolutionString = separator + episodeResolution;
        }
        inputFilename = filenameShow
            + separator + seasonNumString
            + separator + episodeNumString
            + resolutionString + filenameSuffix;
    }

    @Override
    public String toString() {
        return "EpisodeTestData[" + inputFilename + "]";
    }
}