package com.example.gson;

import java.util.List;

/**
 * Created by Administrator on 2016/7/3.
 */
public class SpaceBenM {

    /**
     * name : 其他
     * id : 11
     * child : [{"specs":[{"specName":"一般规格","id":31}],"name":"饲料鱼","id":26},{"specs":[{"specName":"一般规格","id":32}],"name":"海番虾","id":27},{"specs":[{"specName":"一般规格","id":33}],"name":"其他","id":28}]
     */

    private String name;
    private int id;
    /**
     * specs : [{"specName":"一般规格","id":31}]
     * name : 饲料鱼
     * id : 26
     */

    private List<ChildBean> child;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ChildBean> getChild() {
        return child;
    }

    public void setChild(List<ChildBean> child) {
        this.child = child;
    }

    public static class ChildBean {
        private String name;
        private int id;
        /**
         * specName : 一般规格
         * id : 31
         */

        private List<SpecsBean> specs;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<SpecsBean> getSpecs() {
            return specs;
        }

        public void setSpecs(List<SpecsBean> specs) {
            this.specs = specs;
        }

        public static class SpecsBean {
            private String specName;
            private int id;

            public String getSpecName() {
                return specName;
            }

            public void setSpecName(String specName) {
                this.specName = specName;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }
    }
}
