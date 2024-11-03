package edu.epam.fop.lambdas;

import java.util.Comparator;

public interface Comparators {

    static Comparator<Address> ZIP_CODE_COMPARATOR =
            ((o1, o2) -> {
                if (o1 == null && o2 == null) {
                    throw new NullPointerException();
                }
                if (o1 == null) {
                    return -1;
                } else {
                    if (o2 == null) {
                        return 1;
                    }
                }
                return o2.zipCode() - o1.zipCode();
            });

    static Comparator<Address> STREET_COMPARATOR = ((o1, o2) -> {
        if(checkIfNullAsc(o1, o2) != Integer.MAX_VALUE) {
            return checkIfNullAsc(o1 ,o2);
        }


            int streetCpr = checkIfNullDesc(o1.street(), o2.street());
            if (streetCpr == Integer.MAX_VALUE) {
                if (o1.street().compareTo(o2.street()) != 0) {
                    return o1.street().compareTo(o2.street());
                }
            } else {
                if (streetCpr != 0) {
                    return streetCpr;
                }
            }

            int buildingCpr = checkIfNullDesc(o1.building(), o2.building());
            if (buildingCpr == Integer.MAX_VALUE) {
                if (o1.building().compareTo(o2.building()) != 0) {
                    return o1.building().compareTo(o2.building());
                }
            } else {
                if (buildingCpr != 0) {
                    return buildingCpr;
                }
            }

            int appartmentCpr = checkIfNullDesc(o1.apartment(), o2.apartment());
            if (appartmentCpr == Integer.MAX_VALUE) {
                if (o1.apartment().compareTo(o2.apartment()) != 0) {
                    return o1.apartment().compareTo(o2.apartment());
                }
            } else {
                return appartmentCpr;
            }
        return 0;
    });

    static Comparator<Address> REGION_COMPARATOR = ((o1, o2) -> {
        if(checkIfNullAsc(o1, o2) != Integer.MAX_VALUE){
            return checkIfNullAsc(o1, o2);
        }

        int countryCpr=checkIfNullDesc(o1.country(), o2.country());
        if(countryCpr == Integer.MAX_VALUE){
            if(o1.country().compareTo(o2.country()) !=0){
                return o1.country().compareTo(o2.country());
            }
        }else if(countryCpr !=0){
            return countryCpr;
        }

        int cityCpr=checkIfNullDesc(o1.city(), o2.city());
        if(cityCpr == Integer.MAX_VALUE){
            if(o1.city().compareTo(o2.city()) !=0){
                return o1.city().compareTo(o2.city());
            }
        }else if(cityCpr !=0){
            return cityCpr;
        }
        int zipcodeCpr=checkIfNullDesc(o1.zipCode(), o2.zipCode());
        if(zipcodeCpr == Integer.MAX_VALUE){
            if(o1.zipCode().compareTo(o2.zipCode()) !=0){
                return o2.zipCode().compareTo(o1.zipCode());
            }
        }else if(zipcodeCpr == 0 || zipcodeCpr == 1 || zipcodeCpr == -1){
            throw new NullPointerException();
        }
        return 0;
    });

    static Comparator<Address> ADDRESS_COMPARATOR = ((o1, o2) -> {

        if(checkIfNullDesc(o1, o2)!= Integer.MAX_VALUE){
            return checkIfNullDesc(o1, o2);
        }
        if(REGION_COMPARATOR.compare(o1, o2) == 0){
            return STREET_COMPARATOR.compare(o1, o2);
        }else
            return REGION_COMPARATOR.compare (o1, o2);

    });

    static Comparator<Person> FULL_NAME_COMPARATOR = ((o1, o2) -> {
        if(checkIfNullAsc(o1, o2) != Integer.MAX_VALUE){
            return checkIfNullAsc(o1, o2);
        }
        int nameCpr=checkIfNullAsc(o1.name(), o2.name());
        if(nameCpr == Integer.MAX_VALUE){
            if(o1.name().compareTo(o2.name()) != 0){
                return o1.name().compareTo(o2.name());
            }
        }else {
            throw new NullPointerException();
        }
        int surnameCpr=checkIfNullAsc(o1.surname(), o2.surname());
        if(surnameCpr == Integer.MAX_VALUE){
            if(o1.surname().compareTo(o2.surname()) !=0 ){
                return o1.surname().compareTo(o2.surname());
            }
        }else {
            throw new NullPointerException();
        }
        return 0;
    });

    static Comparator<Person> BIRTHDATE_COMPARATOR = ((o1, o2) -> {
        if (checkIfNullAsc(o1, o2) != Integer.MAX_VALUE) {
            return checkIfNullAsc(o1,o2);
        }
        int birthdateCpr=checkIfNullDesc(o1.birthdate(), o2.birthdate());
        if(birthdateCpr == Integer.MAX_VALUE){
            return o2.birthdate().compareTo(o1.birthdate());
        }
        return birthdateCpr;
    });

    static Comparator<Person> PERSON_COMPARATOR = ((o1, o2) -> {
            if(checkIfNullDesc(o1, o2) != Integer.MAX_VALUE){
                return checkIfNullDesc(o1, o2);
            }
            if(Comparators.FULL_NAME_COMPARATOR.compare(o1, o2) == 0){
                if(Comparators.BIRTHDATE_COMPARATOR.compare(o1, o2) == 0){
                    if(Comparators.REGION_COMPARATOR.compare(o1.address(), o2.address()) == 0){
                        return STREET_COMPARATOR.compare(o1.address(), o2.address());
                    }else return Comparators.REGION_COMPARATOR.compare(o1.address(), o2.address());
                }else return Comparators.BIRTHDATE_COMPARATOR.compare(o1, o2);
            }else return Comparators.FULL_NAME_COMPARATOR.compare(o1, o2);
    })  ;
    static Comparator<Company> REGISTRATION_ID_COMPARATOR = ((o1, o2) -> {
        if(checkIfNullDesc(o1, o2) != Integer.MAX_VALUE){
            return checkIfNullDesc(o1, o2);
        }
        int regUUdCpr=checkIfNullAsc(o1.registrationUuid(), o2.registrationUuid());
        if(regUUdCpr == Integer.MAX_VALUE){
            return o1.registrationUuid().compareTo(o2.registrationUuid());
        }else throw new NullPointerException();
    });

    static Comparator<Company> COMPANY_COMPARATOR = ((o1, o2) -> {
        if(checkIfNullDesc(o1, o2) !=Integer.MAX_VALUE){
            return checkIfNullDesc(o1, o2);
        }
        int nameCpr=checkIfNullDesc(o1.name(), o2.name());
        if(nameCpr == Integer.MAX_VALUE){
            if(o1.name().compareTo(o2.name()) != 0){
                return o1.name().compareTo(o2.name());
            }
        } else if(nameCpr != 0){
            return nameCpr;
        }
        if(Comparators.REGISTRATION_ID_COMPARATOR.compare(o1, o2) == 0){
            if(Comparators.FULL_NAME_COMPARATOR.compare(o1.director(), o2.director()) == 0) {
                if (Comparators.BIRTHDATE_COMPARATOR.compare(o1.director(), o2.director()) == 0) {
                    if (Comparators.ADDRESS_COMPARATOR.compare(o1.director().address(), o2.director().address()) == 0) {
                        return ADDRESS_COMPARATOR.compare(o1.officeAddress(), o2.officeAddress());
                    }else return Comparators.ADDRESS_COMPARATOR.compare(o1.director().address(), o2.director().address());
                }else return Comparators.BIRTHDATE_COMPARATOR.compare(o1.director(), o2.director());
            }else return Comparators.FULL_NAME_COMPARATOR.compare(o1.director(), o2.director());
        }else return Comparators.REGISTRATION_ID_COMPARATOR.compare(o1, o2);
    });

    static <T >int checkIfNullAsc(T o1, T o2) {
        if (o1 == null && o2 == null) {
            return 0;
        }else if (o1 == null) {
            return -1;
        } else if (o2 == null) {
                return 1;
            }
        return Integer.MAX_VALUE;
    }
    static <T >int checkIfNullDesc(T o1, T o2) {
        if (o1 == null && o2 == null) {
            return 0;
        }else if (o1 == null) {
            return 1;
        } else if (o2 == null) {
            return -1;
        }
        return Integer.MAX_VALUE;
    }
}