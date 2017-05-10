package com.snslib;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GreenDaoActivity extends AppCompatActivity {
    @BindView(R.id.edit_name)
    EditText mEdtName;
    @BindView(R.id.edit_sex)
    EditText mEdtSex;
    @BindView(R.id.edit_id)
    EditText mEdtId;
    @BindView(R.id.listView)
    ListView mListView;

    private DaoMaster.DevOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoSession mDaoSession;
    private DaoMaster mDaoMaster;
    private PersonDao mPersonDao;
    private Cursor mCursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green_dao);
        ButterKnife.bind(this);

        mHelper = new DaoMaster.DevOpenHelper(this,"test-db",null);
        db = mHelper.getWritableDatabase();
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
        mPersonDao = mDaoSession.getPersonDao();

        mCursor = db.query(mPersonDao.getTablename(),mPersonDao.getAllColumns(),null,null,null,null,null);
        String[] form = {PersonDao.Properties.Name.columnName,PersonDao.Properties.Sex.columnName};
        int[] to = {android.R.id.text1,android.R.id.text2};
        SimpleCursorAdapter simpleCursorAdapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_2,mCursor,form,to, Adapter.NO_SELECTION);
//        mListView.setAdapter(simpleCursorAdapter);
    }

    private void add() {

    }
}
