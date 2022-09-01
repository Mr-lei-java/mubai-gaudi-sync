package com.mubai.sync.bean.order;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author leitengfei
 */
public class OrderBean {

    @JsonProperty("client")
    private String client;
    @JsonProperty("erpCode")
    private String erpCode;
    @JsonProperty("name")
    private String name;
    @JsonProperty("createDpt")
    private String createDpt;
    @JsonProperty("projectName")
    private String projectName;
    @JsonProperty("interfaceType")
    private String interfaceType;
    @JsonProperty("text")
    private String text;
    @JsonProperty("type")
    private String type;
    @JsonProperty("nodes")
    private List<NodesDTO> nodes;

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getErpCode() {
        return erpCode;
    }

    public void setErpCode(String erpCode) {
        this.erpCode = erpCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreateDpt() {
        return createDpt;
    }

    public void setCreateDpt(String createDpt) {
        this.createDpt = createDpt;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getInterfaceType() {
        return interfaceType;
    }

    public void setInterfaceType(String interfaceType) {
        this.interfaceType = interfaceType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<NodesDTO> getNodes() {
        return nodes;
    }

    public void setNodes(List<NodesDTO> nodes) {
        this.nodes = nodes;
    }

    public static class NodesDTO {
        @JsonProperty("index")
        private Integer index;
        @JsonProperty("specification")
        private String specification;
        @JsonProperty("overtime")
        private String overtime;
        @JsonProperty("prodCode")
        private String prodCode;
        @JsonProperty("prodNo")
        private Double prodNo;
        @JsonProperty("componentCode")
        private String componentCode;
        @JsonProperty("packageVolume")
        private Integer packageVolume;
        @JsonProperty("text")
        private String text;

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }

        public String getSpecification() {
            return specification;
        }

        public void setSpecification(String specification) {
            this.specification = specification;
        }

        public String getOvertime() {
            return overtime;
        }

        public void setOvertime(String overtime) {
            this.overtime = overtime;
        }

        public String getProdCode() {
            return prodCode;
        }

        public void setProdCode(String prodCode) {
            this.prodCode = prodCode;
        }

        public Double getProdNo() {
            return prodNo;
        }

        public void setProdNo(Double prodNo) {
            this.prodNo = prodNo;
        }

        public String getComponentCode() {
            return componentCode;
        }

        public void setComponentCode(String componentCode) {
            this.componentCode = componentCode;
        }

        public Integer getPackageVolume() {
            return packageVolume;
        }

        public void setPackageVolume(Integer packageVolume) {
            this.packageVolume = packageVolume;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            NodesDTO nodesDTO = (NodesDTO) o;

            if (index != null ? !index.equals(nodesDTO.index) : nodesDTO.index != null) {
                return false;
            }
            if (specification != null ? !specification.equals(nodesDTO.specification) : nodesDTO.specification != null) {
                return false;
            }
            if (overtime != null ? !overtime.equals(nodesDTO.overtime) : nodesDTO.overtime != null) {
                return false;
            }
            if (prodCode != null ? !prodCode.equals(nodesDTO.prodCode) : nodesDTO.prodCode != null) {
                return false;
            }
            if (prodNo != null ? !prodNo.equals(nodesDTO.prodNo) : nodesDTO.prodNo != null) {
                return false;
            }
            if (componentCode != null ? !componentCode.equals(nodesDTO.componentCode) : nodesDTO.componentCode != null) {
                return false;
            }
            if (packageVolume != null ? !packageVolume.equals(nodesDTO.packageVolume) : nodesDTO.packageVolume != null) {
                return false;
            }
            return text != null ? text.equals(nodesDTO.text) : nodesDTO.text == null;
        }

        @Override
        public int hashCode() {
            int result = index != null ? index.hashCode() : 0;
            result = 31 * result + (specification != null ? specification.hashCode() : 0);
            result = 31 * result + (overtime != null ? overtime.hashCode() : 0);
            result = 31 * result + (prodCode != null ? prodCode.hashCode() : 0);
            result = 31 * result + (prodNo != null ? prodNo.hashCode() : 0);
            result = 31 * result + (componentCode != null ? componentCode.hashCode() : 0);
            result = 31 * result + (packageVolume != null ? packageVolume.hashCode() : 0);
            result = 31 * result + (text != null ? text.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "NodesDTO{" +
                    "index=" + index +
                    ", specification='" + specification + '\'' +
                    ", overtime='" + overtime + '\'' +
                    ", prodCode='" + prodCode + '\'' +
                    ", prodNo=" + prodNo +
                    ", componentCode='" + componentCode + '\'' +
                    ", packageVolume=" + packageVolume +
                    ", text='" + text + '\'' +
                    '}';
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        OrderBean orderBean = (OrderBean) o;

        if (client != null ? !client.equals(orderBean.client) : orderBean.client != null) {
            return false;
        }
        if (erpCode != null ? !erpCode.equals(orderBean.erpCode) : orderBean.erpCode != null) {
            return false;
        }
        if (name != null ? !name.equals(orderBean.name) : orderBean.name != null) {
            return false;
        }
        if (createDpt != null ? !createDpt.equals(orderBean.createDpt) : orderBean.createDpt != null) {
            return false;
        }
        if (projectName != null ? !projectName.equals(orderBean.projectName) : orderBean.projectName != null) {
            return false;
        }
        if (interfaceType != null ? !interfaceType.equals(orderBean.interfaceType) : orderBean.interfaceType != null) {
            return false;
        }
        if (text != null ? !text.equals(orderBean.text) : orderBean.text != null) {
            return false;
        }
        if (type != null ? !type.equals(orderBean.type) : orderBean.type != null) {
            return false;
        }
        return nodes != null ? nodes.equals(orderBean.nodes) : orderBean.nodes == null;
    }

    @Override
    public int hashCode() {
        int result = client != null ? client.hashCode() : 0;
        result = 31 * result + (erpCode != null ? erpCode.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (createDpt != null ? createDpt.hashCode() : 0);
        result = 31 * result + (projectName != null ? projectName.hashCode() : 0);
        result = 31 * result + (interfaceType != null ? interfaceType.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (nodes != null ? nodes.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrderBean{" +
                "client='" + client + '\'' +
                ", erpCode='" + erpCode + '\'' +
                ", name='" + name + '\'' +
                ", createDpt='" + createDpt + '\'' +
                ", projectName='" + projectName + '\'' +
                ", interfaceType='" + interfaceType + '\'' +
                ", text='" + text + '\'' +
                ", type='" + type + '\'' +
                ", nodes=" + nodes +
                '}';
    }
}
