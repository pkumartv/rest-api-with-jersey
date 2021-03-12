package org.rest.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.rest.messenger.database.DatabaseClass;
import org.rest.messenger.model.Comment;
import org.rest.messenger.model.Message;

public class CommentService {
   
    private Map<Long,Message> messages= DatabaseClass.getMessages();

    public List<Comment> getAllComments(long messageId){

        Map<Long,Comment> comments= messages.get(messageId).getComments();
        return new ArrayList<Comment>(comments.values());
    }

    public Comment getComment(long messageId, long commentId){
        Map<Long,Comment> comments= messages.get(messageId).getComments();
        return comments.get(commentId);
    }

    public Comment addComment(long messageId,Comment comment){
        Map<Long,Comment> comments= messages.get(messageId).getComments();
        comment.setId(comments.size()+1);
        comments.put(comment.getId(), comment);
        return comment;
        
    }

    public Comment updateComment(long messageId, Comment comment){
        Map<Long,Comment> comments= messages.get(messageId).getComments();
        if(comment.getId() <=0){
            return null;
        }
        comments.put(comment.getId(), comment);
        return comment;

    }

    public Comment  deleteComment(long messageId, long commentId){
        Map<Long,Comment> comments= messages.get(messageId).getComments();
        return comments.remove(commentId);

    }

}
