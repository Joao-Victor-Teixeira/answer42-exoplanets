package com.joaodev.answer42_api.tests;

import com.joaodev.answer42_api.models.entities.Exoplanets;

public class ExoplanetsFactory {

    public static Exoplanets createExoplanets() {
        Exoplanets exoplanets = new Exoplanets("697957798c73b0fceffff2dd", "55 Cnc e", "55 Cnc",
                2004, "McDonald Observatory", "Radial Velocity", 1.875, 7.99, null, null, 0.01544, 5172.0, 0.943,
                0.905, null, true, true, false,
                "<a refstr=BOURRIER_ET_AL__2018 href=https://ui.adsabs.harvard.edu/abs/2018A&A...619A...1B/abstract target=ref>Bourrier et al. 2018</a>");
        return exoplanets;        
    }
}
