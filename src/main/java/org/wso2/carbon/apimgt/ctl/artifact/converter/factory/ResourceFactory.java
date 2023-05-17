package org.wso2.carbon.apimgt.ctl.artifact.converter.factory;

import org.wso2.carbon.apimgt.ctl.artifact.converter.Constants;
import org.wso2.carbon.apimgt.ctl.artifact.converter.model.APIInfo;
import org.wso2.carbon.apimgt.ctl.artifact.converter.model.Certificates;
import org.wso2.carbon.apimgt.ctl.artifact.converter.model.DocumentsDirectory;
import org.wso2.carbon.apimgt.ctl.artifact.converter.model.Sequences;
import org.wso2.carbon.apimgt.ctl.artifact.converter.model.v32.V32APIInfo;
import org.wso2.carbon.apimgt.ctl.artifact.converter.model.v32.V32DocumentsDirectory;
import org.wso2.carbon.apimgt.ctl.artifact.converter.model.v32.V32Certificates;
import org.wso2.carbon.apimgt.ctl.artifact.converter.model.v32.V32Sequences;
import org.wso2.carbon.apimgt.ctl.artifact.converter.model.v42.V42APIInfo;
import org.wso2.carbon.apimgt.ctl.artifact.converter.model.v42.V42APIPolicies;
import org.wso2.carbon.apimgt.ctl.artifact.converter.model.v42.V42DocumentsDirectory;
import org.wso2.carbon.apimgt.ctl.artifact.converter.model.v42.V42Certificates;

public class ResourceFactory {
    public static DocumentsDirectory getDocumentsRepresentation(String version) {
        if (version.equals(Constants.V320)) {
            return new V32DocumentsDirectory();
        } else if (version.equals(Constants.V420)) {
            return new V42DocumentsDirectory();
        } else {
            return null;
        }
    }

    public static Certificates getEPCertificatesRepresentation(String version) {
        if (version.equals(Constants.V320)) {
            return new V32Certificates();
        } else if (version.equals(Constants.V420)) {
            return new V42Certificates();
        } else {
            return null;
        }
    }

    public static APIInfo getAPIInfoRepresentation(String version) {
        if (version.equals(Constants.V320)) {
            return new V32APIInfo();
        } else if (version.equals(Constants.V420)) {
            return new V42APIInfo();
        } else {
            return null;
        }
    }

    public static Sequences getSequencesRepresentation(String version) {
        if (version.equals(Constants.V320)) {
            return new V32Sequences();
        } else if (version.equals(Constants.V420)) {
            return new V42APIPolicies();
        } else {
            return null;
        }
    }
}
