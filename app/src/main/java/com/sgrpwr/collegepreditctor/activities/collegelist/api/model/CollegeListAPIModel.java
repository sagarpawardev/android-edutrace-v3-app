package com.sgrpwr.collegepreditctor.activities.collegelist.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CollegeListAPIModel {
    @SerializedName("count")
    int count;

    @SerializedName("next")
    String next;

    @SerializedName("previous")
    String previous;

    @SerializedName("results")
    List<CollegeListItem> results;


    public class CollegeListItem {
        @SerializedName("college_name")
        String collegeName;

        @SerializedName("branch_name")
        String branchName;

        @SerializedName("college_code")
        String collegeCode;

        @SerializedName("city")
        String city;

        @SerializedName("cutoff_type")
        String quota;

        @SerializedName("stage_mark")
        int cutoffMark;

        @SerializedName("stage_rank")
        int cutoffRank;

        public String getCollegeName() {
            return collegeName;
        }

        public void setCollegeName(String collegeName) {
            this.collegeName = collegeName;
        }

        public String getBranchName() {
            return branchName;
        }

        public void setBranchName(String branchName) {
            this.branchName = branchName;
        }

        public String getCollegeCode() {
            return collegeCode;
        }

        public void setCollegeCode(String collegeCode) {
            this.collegeCode = collegeCode;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getQuota() {
            return quota;
        }

        public void setQuota(String quota) {
            this.quota = quota;
        }

        public int getCutoffMark() {
            return cutoffMark;
        }

        public void setCutoffMark(int cutoffMark) {
            this.cutoffMark = cutoffMark;
        }

        public int getCutoffRank() {
            return cutoffRank;
        }

        public void setCutoffRank(int cutoffRank) {
            this.cutoffRank = cutoffRank;
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<CollegeListItem> getResults() {
        return results;
    }

    public void setResults(List<CollegeListItem> results) {
        this.results = results;
    }
}
