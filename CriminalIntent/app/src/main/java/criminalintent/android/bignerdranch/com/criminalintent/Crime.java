package criminalintent.android.bignerdranch.com.criminalintent;

import java.util.UUID;

/**
 * Created by KURT W8 on 10/27/2014.
 */
public class Crime {
    private UUID mId;
    private String mTitle;

    public Crime() {
        mId = UUID.randomUUID();
    }

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
