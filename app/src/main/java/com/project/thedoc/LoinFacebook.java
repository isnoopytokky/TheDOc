package com.project.thedoc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

/**
 * Created by kanokwan on 3/8/15 AD.
 */



public class LoinFacebook  extends Activity{
    private static String TAG = LoinFacebook.class.getSimpleName();
    private final String APPLICATION_ID = "0YtlAoFXct0MIY50YhLVDQtwc9SL9xnS21w20BJz";
    private final String CLIENT_KEY = "WN2u3KtbrQdp4wbd4ZEaN7wVIPvWpMs8wNAhbFFf";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Parse.initialize(this, APPLICATION_ID, CLIENT_KEY);

        setContentView(R.layout.login_facebook);

        Button authButton = (Button) findViewById(R.id.authButton);

        authButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //
                ParseQuery<ParseObject> query = ParseQuery.getQuery("Player");

                // Retrieve the object by id
                query.getInBackground("VMeoDcRp9G", new GetCallback<ParseObject>() {
                    public void done(ParseObject gameScore, ParseException e) {
                        if (e == null) {
                            // Now let's update it with some new data. In this case, only cheatMode and score
                            // will get sent to the Parse Cloud. playerName hasn't changed.
                            gameScore.put("position", 10);
                            gameScore.saveInBackground();
                        }
                    }
                });
                //
                Intent i = new Intent(LoinFacebook.this, MainActivity.class);
                startActivity(i);
            }
        });

    }

   /*
        public static class PlaceholderFragment extends Fragment {
        private UiLifecycleHelper uiHelper;
        private Session.StatusCallback callback = new Session.StatusCallback() {
            @Override
            public void call(Session session, SessionState state, Exception exception) {
                onSessionStateChange(session, state, exception);
            }
        };

        public PlaceholderFragment() {
        }

        private void onSessionStateChange(Session session, SessionState state, Exception exception) {
            if (state.isOpened()) {

                Request request = Request.newMeRequest(session, new Request.GraphUserCallback() {

                    @Override
                    public void onCompleted(GraphUser user, Response response) {
                        Toast.makeText(getActivity(),
                                "Hello " + user.getName(),
                                Toast.LENGTH_LONG).show();
                    }
                });
                request.executeAsync();

            } else if (state.isClosed()) {
                Log.i(TAG, "Logged out...");
            }
        }

        @Override
        public void onResume() {
            super.onResume();

            Session session = Session.getActiveSession();
            if (session != null &&
                    (session.isOpened() || session.isClosed())) {
                onSessionStateChange(session, session.getState(), null);
            }

            uiHelper.onResume();
        }

        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            uiHelper.onActivityResult(requestCode, resultCode, data);
        }

        @Override
        public void onPause() {
            super.onPause();
            uiHelper.onPause();
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            uiHelper.onDestroy();
        }

        @Override
        public void onSaveInstanceState(Bundle outState) {
            super.onSaveInstanceState(outState);
            uiHelper.onSaveInstanceState(outState);
        }

    }*/
}
