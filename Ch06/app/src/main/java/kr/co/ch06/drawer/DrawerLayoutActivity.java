package kr.co.ch06.drawer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import kr.co.ch06.R;

public class DrawerLayoutActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private View drawerMenu;
    private Button btnDrawerOpen, btnDrawerClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout);

        drawerLayout = findViewById(R.id.drawer_layout);
        drawerMenu = findViewById(R.id.drawer_layout_menu);

        btnDrawerOpen = findViewById(R.id.btn_drawer_open);
        btnDrawerClose = findViewById(R.id.btn_drawer_close);

        btnDrawerOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(drawerMenu);
            }
        });

        btnDrawerClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(drawerMenu);
            }
        });

    }
}
