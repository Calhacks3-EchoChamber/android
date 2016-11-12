package com.calhacks.echochamber;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.calhacks.echochamber.Topic.TestTopics;
import com.calhacks.echochamber.Topic.Topic;
import com.calhacks.echochamber.Topic.TopicListAdapter;


public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";
    private NavigationDrawer navigationDrawer;
    private ListView topicList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationDrawer = new NavigationDrawer(this, getWindow().getDecorView(), "Topics");
        navigationDrawer.init();

        Topic[] topics = TestTopics.getTopics();
        topicList = (ListView) findViewById(R.id.topic_list);
        topicList.setAdapter(new TopicListAdapter(this, topics));
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        navigationDrawer.getDrawerToggle().syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        navigationDrawer.getDrawerToggle().onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (navigationDrawer.getDrawerToggle().onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
