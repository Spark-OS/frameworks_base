/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package android.app.role;

import android.annotation.NonNull;
import android.annotation.SystemApi;
import android.os.Parcelable;

import com.android.internal.util.DataClass;

import java.util.List;

/**
 * Describes a set of privileges granted by a {@link RoleManager role}
 *
 * @hide
 */
@SystemApi
@DataClass
public final class RolePrivileges implements Parcelable {

    /**
     * An identifier of a role holder app being granted the
     * {@link android.service.notification.NotificationListenerService Notification Access}
     * privilege.
     */
    public static final String CAPABILITY_NOTIFICATION_LISTENER =
            "android.app.role.capability.NOTIFICATION_LISTENER";

    /**
     * Permissions granted to the role holder(s).
     */
    private @NonNull List<String> mPermissions;
    /**
     * Appop permissions granted to the role holder(s).
     */
    private @NonNull List<String> mAppOpPermissions;
    /**
     * Appops granted to the role holder(s).
     */
    private @NonNull List<String> mAppOps;
    /**
     * Special access granted to the role holder(s).
     *
     * @see #CAPABILITY_NOTIFICATION_LISTENER
     */
    private @NonNull List<String> mCapabilities;



    // Code below generated by codegen v1.0.22.
    //
    // DO NOT MODIFY!
    // CHECKSTYLE:OFF Generated code
    //
    // To regenerate run:
    // $ codegen $ANDROID_BUILD_TOP/frameworks/base/core/java/android/app/role/RolePrivileges.java
    //
    // To exclude the generated code from IntelliJ auto-formatting enable (one-time):
    //   Settings > Editor > Code Style > Formatter Control
    //@formatter:off


    /**
     * Creates a new RolePrivileges.
     *
     * @param permissions
     *   Permissions granted to the role holder(s).
     * @param appOpPermissions
     *   Appop permissions granted to the role holder(s).
     * @param appOps
     *   Appops granted to the role holder(s).
     * @param capabilities
     *   Special access granted to the role holder(s).
     */
    @DataClass.Generated.Member
    public RolePrivileges(
            @NonNull List<String> permissions,
            @NonNull List<String> appOpPermissions,
            @NonNull List<String> appOps,
            @NonNull List<String> capabilities) {
        this.mPermissions = permissions;
        com.android.internal.util.AnnotationValidations.validate(
                NonNull.class, null, mPermissions);
        this.mAppOpPermissions = appOpPermissions;
        com.android.internal.util.AnnotationValidations.validate(
                NonNull.class, null, mAppOpPermissions);
        this.mAppOps = appOps;
        com.android.internal.util.AnnotationValidations.validate(
                NonNull.class, null, mAppOps);
        this.mCapabilities = capabilities;
        com.android.internal.util.AnnotationValidations.validate(
                NonNull.class, null, mCapabilities);

        // onConstructed(); // You can define this method to get a callback
    }

    /**
     * Permissions granted to the role holder(s).
     */
    @DataClass.Generated.Member
    public @NonNull List<String> getPermissions() {
        return mPermissions;
    }

    /**
     * Appop permissions granted to the role holder(s).
     */
    @DataClass.Generated.Member
    public @NonNull List<String> getAppOpPermissions() {
        return mAppOpPermissions;
    }

    /**
     * Appops granted to the role holder(s).
     */
    @DataClass.Generated.Member
    public @NonNull List<String> getAppOps() {
        return mAppOps;
    }

    /**
     * Special access granted to the role holder(s).
     *
     * @see #CAPABILITY_NOTIFICATION_LISTENER
     */
    @DataClass.Generated.Member
    public @NonNull List<String> getCapabilities() {
        return mCapabilities;
    }

    @Override
    @DataClass.Generated.Member
    public void writeToParcel(@NonNull android.os.Parcel dest, int flags) {
        // You can override field parcelling by defining methods like:
        // void parcelFieldName(Parcel dest, int flags) { ... }

        dest.writeStringList(mPermissions);
        dest.writeStringList(mAppOpPermissions);
        dest.writeStringList(mAppOps);
        dest.writeStringList(mCapabilities);
    }

    @Override
    @DataClass.Generated.Member
    public int describeContents() { return 0; }

    /** @hide */
    @SuppressWarnings({"unchecked", "RedundantCast"})
    @DataClass.Generated.Member
    /* package-private */ RolePrivileges(@NonNull android.os.Parcel in) {
        // You can override field unparcelling by defining methods like:
        // static FieldType unparcelFieldName(Parcel in) { ... }

        List<String> permissions = new java.util.ArrayList<>();
        in.readStringList(permissions);
        List<String> appOpPermissions = new java.util.ArrayList<>();
        in.readStringList(appOpPermissions);
        List<String> appOps = new java.util.ArrayList<>();
        in.readStringList(appOps);
        List<String> capabilities = new java.util.ArrayList<>();
        in.readStringList(capabilities);

        this.mPermissions = permissions;
        com.android.internal.util.AnnotationValidations.validate(
                NonNull.class, null, mPermissions);
        this.mAppOpPermissions = appOpPermissions;
        com.android.internal.util.AnnotationValidations.validate(
                NonNull.class, null, mAppOpPermissions);
        this.mAppOps = appOps;
        com.android.internal.util.AnnotationValidations.validate(
                NonNull.class, null, mAppOps);
        this.mCapabilities = capabilities;
        com.android.internal.util.AnnotationValidations.validate(
                NonNull.class, null, mCapabilities);

        // onConstructed(); // You can define this method to get a callback
    }

    @DataClass.Generated.Member
    public static final @NonNull Parcelable.Creator<RolePrivileges> CREATOR
            = new Parcelable.Creator<RolePrivileges>() {
        @Override
        public RolePrivileges[] newArray(int size) {
            return new RolePrivileges[size];
        }

        @Override
        public RolePrivileges createFromParcel(@NonNull android.os.Parcel in) {
            return new RolePrivileges(in);
        }
    };

    @DataClass.Generated(
            time = 1607546429137L,
            codegenVersion = "1.0.22",
            sourceFile = "frameworks/base/core/java/android/app/role/RolePrivileges.java",
            inputSignatures = "public static final  java.lang.String CAPABILITY_NOTIFICATION_LISTENER\nprivate @android.annotation.NonNull java.util.List<java.lang.String> mPermissions\nprivate @android.annotation.NonNull java.util.List<java.lang.String> mAppOpPermissions\nprivate @android.annotation.NonNull java.util.List<java.lang.String> mAppOps\nprivate @android.annotation.NonNull java.util.List<java.lang.String> mCapabilities\nclass RolePrivileges extends java.lang.Object implements [android.os.Parcelable]\n@com.android.internal.util.DataClass")
    @Deprecated
    private void __metadata() {}


    //@formatter:on
    // End of generated code

}
