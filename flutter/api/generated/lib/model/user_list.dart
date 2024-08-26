//
// AUTO-GENERATED FILE, DO NOT MODIFY!
//
// @dart=2.18

// ignore_for_file: unused_element, unused_import
// ignore_for_file: always_put_required_named_parameters_first
// ignore_for_file: constant_identifier_names
// ignore_for_file: lines_longer_than_80_chars

part of openapi.api;

class UserList {
  /// Returns a new [UserList] instance.
  UserList({
    this.users = const [],
    this.totalCount,
    this.page,
    this.limit,
  });

  List<User> users;

  ///
  /// Please note: This property should have been non-nullable! Since the specification file
  /// does not include a default value (using the "default:" property), however, the generated
  /// source code must fall back to having a nullable type.
  /// Consider adding a "default:" property in the specification file to hide this note.
  ///
  int? totalCount;

  ///
  /// Please note: This property should have been non-nullable! Since the specification file
  /// does not include a default value (using the "default:" property), however, the generated
  /// source code must fall back to having a nullable type.
  /// Consider adding a "default:" property in the specification file to hide this note.
  ///
  int? page;

  ///
  /// Please note: This property should have been non-nullable! Since the specification file
  /// does not include a default value (using the "default:" property), however, the generated
  /// source code must fall back to having a nullable type.
  /// Consider adding a "default:" property in the specification file to hide this note.
  ///
  int? limit;

  @override
  bool operator ==(Object other) => identical(this, other) || other is UserList &&
    _deepEquality.equals(other.users, users) &&
    other.totalCount == totalCount &&
    other.page == page &&
    other.limit == limit;

  @override
  int get hashCode =>
    // ignore: unnecessary_parenthesis
    (users.hashCode) +
    (totalCount == null ? 0 : totalCount!.hashCode) +
    (page == null ? 0 : page!.hashCode) +
    (limit == null ? 0 : limit!.hashCode);

  @override
  String toString() => 'UserList[users=$users, totalCount=$totalCount, page=$page, limit=$limit]';

  Map<String, dynamic> toJson() {
    final json = <String, dynamic>{};
      json[r'users'] = this.users;
    if (this.totalCount != null) {
      json[r'totalCount'] = this.totalCount;
    } else {
      json[r'totalCount'] = null;
    }
    if (this.page != null) {
      json[r'page'] = this.page;
    } else {
      json[r'page'] = null;
    }
    if (this.limit != null) {
      json[r'limit'] = this.limit;
    } else {
      json[r'limit'] = null;
    }
    return json;
  }

  /// Returns a new [UserList] instance and imports its values from
  /// [value] if it's a [Map], null otherwise.
  // ignore: prefer_constructors_over_static_methods
  static UserList? fromJson(dynamic value) {
    if (value is Map) {
      final json = value.cast<String, dynamic>();

      // Ensure that the map contains the required keys.
      // Note 1: the values aren't checked for validity beyond being non-null.
      // Note 2: this code is stripped in release mode!
      assert(() {
        requiredKeys.forEach((key) {
          assert(json.containsKey(key), 'Required key "UserList[$key]" is missing from JSON.');
          assert(json[key] != null, 'Required key "UserList[$key]" has a null value in JSON.');
        });
        return true;
      }());

      return UserList(
        users: User.listFromJson(json[r'users']),
        totalCount: mapValueOfType<int>(json, r'totalCount'),
        page: mapValueOfType<int>(json, r'page'),
        limit: mapValueOfType<int>(json, r'limit'),
      );
    }
    return null;
  }

  static List<UserList> listFromJson(dynamic json, {bool growable = false,}) {
    final result = <UserList>[];
    if (json is List && json.isNotEmpty) {
      for (final row in json) {
        final value = UserList.fromJson(row);
        if (value != null) {
          result.add(value);
        }
      }
    }
    return result.toList(growable: growable);
  }

  static Map<String, UserList> mapFromJson(dynamic json) {
    final map = <String, UserList>{};
    if (json is Map && json.isNotEmpty) {
      json = json.cast<String, dynamic>(); // ignore: parameter_assignments
      for (final entry in json.entries) {
        final value = UserList.fromJson(entry.value);
        if (value != null) {
          map[entry.key] = value;
        }
      }
    }
    return map;
  }

  // maps a json object with a list of UserList-objects as value to a dart map
  static Map<String, List<UserList>> mapListFromJson(dynamic json, {bool growable = false,}) {
    final map = <String, List<UserList>>{};
    if (json is Map && json.isNotEmpty) {
      // ignore: parameter_assignments
      json = json.cast<String, dynamic>();
      for (final entry in json.entries) {
        map[entry.key] = UserList.listFromJson(entry.value, growable: growable,);
      }
    }
    return map;
  }

  /// The list of required keys that must be present in a JSON.
  static const requiredKeys = <String>{
  };
}

