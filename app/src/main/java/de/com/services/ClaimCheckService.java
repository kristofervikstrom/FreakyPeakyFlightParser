package com.services;

import com.models.ClaimCheckResult;
import com.models.Flight;

public interface ClaimCheckService {

    ClaimCheckResult runClaimCheck(Flight flight);

}
