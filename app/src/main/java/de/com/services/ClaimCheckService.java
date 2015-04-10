package de.com.services;

import de.com.models.ClaimCheckResult;
import de.com.models.Flight;

public interface ClaimCheckService {

    ClaimCheckResult runClaimCheck(Flight flight);

}
