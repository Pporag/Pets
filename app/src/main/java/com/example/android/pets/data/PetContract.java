package com.example.android.pets.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public final class PetContract {

    // empty constructor
    private  PetContract(){}
    // String Constant for using  in the URI
    public static final String CONTENT_AUTHORITY = "com.example.android.pets";
    //  Parse the URI
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    //This constants stores the path for each of the tables which will be appended to the base content URI.
    public static final String PATH_PETS = "pets";


    // Inner class that defines constant values for the pets database table.
    public static final class PetEntry implements BaseColumns {

        // The Uri.withAppendedPath() method appends the BASE_CONTENT_URI
        // (which contains the scheme and the content authority) to the path segment.
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_PETS);


        /**
         * Returns whether or not the given gender is {@link #GENDER_UNKNOWN}, {@link #GENDER_MALE},
         * or {@link #GENDER_FEMALE}.
         */
        public static boolean isValidGender(int gender) {
            if (gender == GENDER_UNKNOWN || gender == GENDER_MALE || gender == GENDER_FEMALE) {
                return true;
            }
            return false;
        }

        /**
         * The MIME type of the {@link #CONTENT_URI} for a list of pets.
         */
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PETS;

        /**
         * The MIME type of the {@link #CONTENT_URI} for a single pet.
         */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PETS;


        public final static String TABLE_NAME = "pets";
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_PET_NAME = "name";
        public final static String COLUMN_PET_BREED = "breed";
        public final static String COLUMN_PET_GENDER = "gender";
        public final static String COLUMN_PET_WEIGHT = "weight";

        // possible values for gender of the pet
        public final static int GENDER_UNKNOWN = 0;
        public final static int GENDER_MALE = 1;
        public final static int GENDER_FEMALE = 2;

    }
}
