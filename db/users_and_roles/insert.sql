INSERT INTO roles (roles_title) VALUES
('Admin'),
('Moderator'),
('User'),
('Guest');

INSERT INTO rules (rule) VALUES
('Create posts'),
('Edit posts'),
('Delete posts'),
('View posts');

INSERT INTO rules_role (rule_id, role_id) VALUES
(1, 1), -- Admin can create posts
(2, 1), -- Admin can edit posts
(3, 1), -- Admin can delete posts
(4, 1), -- Admin can view posts
(2, 2), -- Moderator can edit posts
(4, 2), -- Moderator can view posts
(4, 3), -- User can view posts
(4, 4); -- Guest can view posts

INSERT INTO users (user_name, roles_id) VALUES
('Alice', 1), -- Alice is an Admin
('Bob', 2),   -- Bob is a Moderator
('Charlie', 3), -- Charlie is a User
('Dave', 4); -- Dave is a Guest

INSERT INTO states (items_status) VALUES
('New'),
('In Progress'),
('Completed'),
('Archived');

INSERT INTO categories (category_item) VALUES
('Electronics'),
('Clothing'),
('Books'),
('Home Appliances');

INSERT INTO items (items_name, user_id, categories_id, states_id) VALUES
('Laptop', 1, 1, 1), -- Laptop in Electronics, New
('T-Shirt', 2, 2, 2), -- T-Shirt in Clothing, In Progress
('Novel', 3, 3, 3), -- Novel in Books, Completed
('Blender', 4, 4, 4); -- Blender in Home Appliances, Archived

INSERT INTO comments (comments_text, items_id) VALUES
('Great laptop!', 1), -- Comment for Laptop
('Nice T-Shirt!', 2), -- Comment for T-Shirt
('Interesting book!', 3), -- Comment for Novel
('Powerful blender!', 4); -- Comment for Blender

INSERT INTO attachs (files, items_id) VALUES
('laptop_image.jpg', 1), -- Attachment for Laptop
('tshirt_image.jpg', 2), -- Attachment for T-Shirt
('novel_cover.jpg', 3), -- Attachment for Novel
('blender_image.jpg', 4); -- Attachment for Blender