package com.ju5.core;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class UserAccountServiceTest {

    @Nested
    class ExistingUserRegistrationTest {
        @Test
        void testRegisterUserWithExistingUser() {}
        @Test
        void testRegisterUserWithExistingMobileNumber() {}
        @Test
        void testRegisterUserWithExistingEmailAddress() {}
    }

    @Nested
    class NewUserRegistrationTest {
        @Test
        void testRegisterUser() {}

        @Test
        void testRegisterUserWithInvalidAgeRange() {}
        @Test
        void testRegisterUserWithInvalidMobileNumber() {}
    }
}
