package com.beilie.test;

import com.beilie.core.exceptions.BusinessException;
import com.beilie.core.security.domain.UserInfo;
import com.beilie.core.test.EFTestBuilder;
import com.beilie.platform.es.api.PlatSecurityManager;

public class EFTester  extends EFTestBuilder{

    public static EFTester build(String serviceName){
        return new EFTester(serviceName);
    }
    protected EFTester(String serviceName) {
        super(serviceName);
    }

    @Override
    protected UserInfo getUserPrincipal() throws BusinessException {
        if(Boolean.TRUE.equals(this.getAP()))
            return PlatSecurityManager.getApplicantPrincipal(this.runAs);
        return PlatSecurityManager.getUserPrincipal(this.runAs);
    }
}
