package org.wso2.carbon.apimgt.ctl.artifact.converter.impl;

import org.wso2.carbon.apimgt.ctl.artifact.converter.ResourceVersionConverter;
import org.wso2.carbon.apimgt.ctl.artifact.converter.exception.CTLArtifactConversionException;
import org.wso2.carbon.apimgt.ctl.artifact.converter.factory.ResourceFactory;
import org.wso2.carbon.apimgt.ctl.artifact.converter.model.EPCertificates;
import org.wso2.carbon.apimgt.ctl.artifact.converter.util.CertificatesMappingUtil;

import java.util.List;

public class EPCertificateVersionConverter extends ResourceVersionConverter {
    EPCertificates srcCertificates;
    EPCertificates targetCertificates;

    public EPCertificateVersionConverter(String srcVersion, String targetVersion, String srcPath, String targetPath,
                                         String exportFormat) {
        super(srcVersion, targetVersion, srcPath, targetPath, exportFormat);
        this.srcCertificates = ResourceFactory.getEPCertificatesRepresentation(srcVersion);
        this.targetCertificates = ResourceFactory.getEPCertificatesRepresentation(targetVersion);
    }
    @Override
    public void convert() throws CTLArtifactConversionException {
        //Import certificate resources from src artifact
        srcCertificates.importCertificates(srcPath);

        //Map imported src certificates to target certificates format
        CertificatesMappingUtil.mapCertificates(srcCertificates, targetCertificates, srcVersion, targetVersion);

        //Export mapped certificates to target artifact
        targetCertificates.exportCertificates(targetPath, exportFormat);
    }
}
