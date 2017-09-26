package ru.axel.meganotes.app.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ru.axel.meganotes.app.models.Note;
import ru.axel.meganotes.app.R;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.NoteViewHolder> {

    private static final boolean DEBUG = false;
    private OnItemClickListener mOnItemClickListener;
    private OnLongItemClickListener mOnLongItemClickListener;
    private List<Note> mNotesList;

    public class NoteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,
            View.OnLongClickListener {

        private TextView mNameNote;
        private TextView mLastUpdateNote;
        private TextView mContentNote;

        public NoteViewHolder(View itemView) {
            super(itemView);

            mNameNote = (TextView) itemView.findViewById(R.id.nameNote);
            mLastUpdateNote = (TextView) itemView.findViewById(R.id.lastUpdateNote);
            mContentNote = (TextView) itemView.findViewById(R.id.content_note);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {

            if (mOnItemClickListener != null) {
                mOnItemClickListener.OnItemClick(v, getAdapterPosition());
            }
        }

        @Override
        public boolean onLongClick(View v) {

            if (mOnLongItemClickListener != null) {
                mOnLongItemClickListener.onLongItemClick(v, getAdapterPosition());
                return true;
            }
            return false;
        }
    }

    public MainAdapter(List<Note> notes) {
        this.mNotesList = notes;
    }

    public interface OnItemClickListener {
        void OnItemClick(View view, int position);
    }

    public interface OnLongItemClickListener {
        void onLongItemClick(View view, int position);
    }

    public void SetOnItemClickListener(final OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void SetOnItemLongClickListener(final OnLongItemClickListener onLongItemClickListener) {
        this.mOnLongItemClickListener = onLongItemClickListener;
    }

    @Override
    public int getItemCount() {
        return mNotesList.size();
    }

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View myView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new NoteViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(NoteViewHolder noteViewHolder, int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) noteViewHolder.mContentNote.getLayoutParams();
        Note note = mNotesList.get(i);
        if (DEBUG) {
            Log.d("LOG", "we have in i is: " + i);
            Log.d("LOG", "we have in NoteList: " + mNotesList.size() + " elements");
            if (i > 0) {
                Log.d("LOG", "we can access to i-1 elem? " + mNotesList.get(i - 1).getNameNote() + " its her name");
            }
        }

        if (!note.getNameNote().isEmpty()) {
            noteViewHolder.mContentNote.setMaxLines(2);
            layoutParams.addRule(RelativeLayout.BELOW, noteViewHolder.mNameNote.getId());
        } else {
            layoutParams.addRule(RelativeLayout.BELOW, 0);
            noteViewHolder.mContentNote.setMaxLines(3);
        }

        noteViewHolder.mContentNote.setLayoutParams(layoutParams);

        noteViewHolder.mNameNote.setText(note.getNameNote());
        noteViewHolder.mContentNote.setText(note.getContent());
        noteViewHolder.mLastUpdateNote.setText(note.getDateLastUpdateNote());
    }
}