package com.example.gson;

import java.util.List;

/**
 * Created by Administrator on 2016/8/22.
 * 任务列表
 */
public class TaskEntriy {


    /**
     * STATU : success
     * RESULT : [{"id":"42","subject":"测试事件2","taskcode":"2016012"},{"id":"36","subject":"测试事件","taskcode":"2016011"}]
     * MESSAGE :
     */

    private String STATU;
    private String MESSAGE;
    /**
     * id : 42
     * subject : 测试事件2
     * taskcode : 2016012
     */

    private List<RESULTBean> RESULT;

    public String getSTATU() {
        return STATU;
    }

    public void setSTATU(String STATU) {
        this.STATU = STATU;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public List<RESULTBean> getRESULT() {
        return RESULT;
    }

    public void setRESULT(List<RESULTBean> RESULT) {
        this.RESULT = RESULT;
    }

    public static class RESULTBean {
        private String id;
        private String subject;
        private String taskcode;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getTaskcode() {
            return taskcode;
        }

        public void setTaskcode(String taskcode) {
            this.taskcode = taskcode;
        }
    }
}
