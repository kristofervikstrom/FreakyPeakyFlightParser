package com.services.hardcoded;

import com.models.ClaimCheckResult;
import com.models.Flight;
import com.services.ClaimCheckService;

import java.util.Random;

public class HardCodedClaimCheck implements ClaimCheckService {

    public static Random random = new Random();

    @Override
    public ClaimCheckResult runClaimCheck(Flight flight) {

        boolean successful = random.nextBoolean();
        int amountClaimed = successful ? Math.abs(random.nextInt()) + 1: 0;
        return new ClaimCheckResult(successful, amountClaimed);
    }
}
