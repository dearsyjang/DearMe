package com.dearme.demo.global.qtype;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.dearme.demo.domain.user.entity.Gender;
import com.dearme.demo.domain.user.entity.GroupUser;
import com.dearme.demo.domain.user.entity.Type;
import com.dearme.demo.domain.user.entity.User;
import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -1409856951L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUser user = new QUser("user");


    public final DateTimePath<java.util.Date> birth = createDateTime("birth", java.util.Date.class);


    public final QCounselorProfile counselorProfile;


    public final StringPath email = createString("email");


    public final EnumPath<Gender> gender = createEnum("gender", Gender.class);

    public final ListPath<GroupUser, QGroupUser> groupUsers = this.<GroupUser, QGroupUser>createList("groupUsers", GroupUser.class, QGroupUser.class, PathInits.DIRECT2);

    public final StringPath id = createString("id");

    public final StringPath nickName = createString("nickName");

    public final StringPath phone = createString("phone");

    public final QPicture picture;

    public final NumberPath<Long> points = createNumber("points", Long.class);

    public final StringPath pw = createString("pw");

    public final StringPath refreshToken = createString("refreshToken");


    public final EnumPath<Type> type = createEnum("type", Type.class);



    public final NumberPath<Long> userId = createNumber("userId", Long.class);


    public QUser(String variable) {
        this(User.class, forVariable(variable), INITS);
    }

    public QUser(Path<? extends User> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUser(PathMetadata metadata, PathInits inits) {
        this(User.class, metadata, inits);
    }

    public QUser(Class<? extends User> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.counselorProfile = inits.isInitialized("counselorProfile") ? new QCounselorProfile(forProperty("counselorProfile"), inits.get("counselorProfile")) : null;
        this.picture = inits.isInitialized("picture") ? new QPicture(forProperty("picture")) : null;
    }

}

